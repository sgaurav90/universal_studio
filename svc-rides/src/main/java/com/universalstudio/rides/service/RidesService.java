package com.universalstudio.rides.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.universalstudio.rides.exception.RidesException;
import com.universalstudio.rides.exception.ValidationFailure;
import com.universalstudio.rides.model.Rides;
import com.universalstudio.rides.model.UserRideDetails;
import com.universalstudio.rides.repository.RidesRepository;
import com.universalstudio.rides.repository.UserRideDetailsRepository;
import com.universalstudio.rides.to.RideTO;
import com.universalstudio.rides.util.DateTimeUtils;

@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class RidesService {

	@Autowired
	private RidesRepository ridesRepository;

	@Autowired
	private UserRideDetailsRepository userRideDetailsRepository;

	public List<RideTO> getRideDetails() {
		List<Rides> rides = ridesRepository.findAll();
		List<RideTO> to = mapTO(rides);
		return to;
	}

	public List<RideTO> getRideDetailsById(Integer rideId) throws RidesException {
		if (rideId == null) {
			throw new RidesException("Ride Id must be entered.");
		}
		List<Rides> rides = ridesRepository.findByRideId(rideId);
		List<RideTO> to = mapTO(rides);
		return to;

	}

	public String bookRide(Integer userId, Rides rides) throws RidesException {
		List<ValidationFailure> errMsg = new ArrayList<>();
		if (userId == null) {
			errMsg.add(new ValidationFailure("User Id must be entered.", "E"));
		}
		if (rides != null) {
			if (rides.getRideId() == null) {
				errMsg.add(new ValidationFailure("Ride Id must be entered.", "E"));
			}
			if (rides.getStartTime() == null) {
				errMsg.add(new ValidationFailure("Start time must be entered.", "E"));
			}
		} else {
			errMsg.add(new ValidationFailure("Ride Details must be entered.", "E"));
		}
		if (errMsg.size() > 0) {
			throw new RidesException(errMsg);
		}
		Rides ride = ridesRepository.findByRideIdAndStartTime(rides.getRideId(), rides.getStartTime());
		if (ride.getRideCapacity() > 0) {
			ride.setRideCapacity(ride.getRideCapacity() - 1);
			Rides result = ridesRepository.save(ride);
			UserRideDetails record = new UserRideDetails();
			record.setRideId(rides.getRideId());
			record.setRideTime(rides.getStartTime());
			record.setUserId(userId);
			userRideDetailsRepository.save(record);
			return "Ride booked Successfully";
		} else {
			return "Seats Not Available";
		}
	}

	private List<RideTO> mapTO(List<Rides> rides) {
		List<RideTO> toList = new ArrayList<>();
		for (Rides ride : rides) {
			if (!DateTimeUtils.formateDateTime(ride.getStartTime()).contains("-") && ride.getRideCapacity() > 0) {
				RideTO to = new RideTO();
				to.setRideId(ride.getRideId());
				to.setRideName(ride.getRideName());
				to.setStartTime(String.valueOf(ride.getStartTime()));
				to.setSeatAvailable(ride.getRideCapacity());
				to.setWaitTime(DateTimeUtils.formateDateTime(ride.getStartTime()));
				toList.add(to);
			}
		}
		return toList;
	}

	public String createRide(List<Rides> rides) throws RidesException {
		if (rides != null && rides.size() > 0) {
			for (Rides ride : rides) {
				if (ride.getRideId() == null) {
					throw new RidesException("Ride Id must be entered.");
				}
				if (ride.getRideName() == null || StringUtils.isBlank(ride.getRideName())) {
					throw new RidesException("Ride Name must be entered.");
				}
				if (ride.getStartTime() == null) {
					throw new RidesException("Start time must be entered.");
				}
				if (ride.getRideCapacity() == null) {
					throw new RidesException("Ride Capacity must be entered.");
				}
			}
		} else {
			throw new RidesException("Please provide the Ride Details.");
		}

		for (Rides ride : rides) {
			ridesRepository.save(ride);
		}
		return "Ride created Successfully";
	}

}

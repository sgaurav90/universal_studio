package com.universalstudio.rides.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.universalstudio.rides.model.Rides;
import com.universalstudio.rides.repository.RidesRepository;
import com.universalstudio.rides.to.RideTO;
import com.universalstudio.rides.util.DateTimeUtils;

@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class RidesService {

	@Autowired
	private RidesRepository ridesRepository;

	public List<RideTO> getRideDetails() {
		List<Rides> rides = ridesRepository.findAll();
		List<RideTO> to = mapTO(rides);
		return to;

	}

	public List<RideTO> getRideDetailsById(Integer rideId) {
		List<Rides> rides = ridesRepository.findByRideId(rideId);
		List<RideTO> to = mapTO(rides);
		return to;

	}

	public String bookRide(Rides rides) {
		Rides ride = ridesRepository.findByRideIdAndStartTime(rides.getRideId(), rides.getStartTime());
		if (ride.getRideCapacity() > 0) {
			ride.setRideCapacity(ride.getRideCapacity() - 1);
			Rides result = ridesRepository.save(ride);
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

	public String createRide(List<Rides> rides) {
		for(Rides ride:rides) {
			ridesRepository.save(ride);
		}
		return "success";
	}

}

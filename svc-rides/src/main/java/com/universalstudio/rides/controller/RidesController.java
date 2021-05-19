package com.universalstudio.rides.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.universalstudio.rides.exception.RidesException;
import com.universalstudio.rides.model.Rides;
import com.universalstudio.rides.service.RidesService;
import com.universalstudio.rides.to.RideTO;

@RestController
@RequestMapping("/universalstudio")
public class RidesController {

	@Autowired
	private RidesService ridesService;

	@RequestMapping(value = "/rides", method = RequestMethod.GET)
	public List<RideTO> getRideDetails() {
		return ridesService.getRideDetails();
	}

	@RequestMapping(value = "/rides/{rideId}", method = RequestMethod.GET)
	public List<RideTO> getRideDetailsById(@PathVariable(name = "rideId") Integer rideId) throws RidesException {
		return ridesService.getRideDetailsById(rideId);
	}

	@RequestMapping(value = "/rides/{userId}", method = RequestMethod.POST)
	public String bookRide(@PathVariable(name = "userId") Integer userId, @RequestBody Rides rides)
			throws RidesException {
		return ridesService.bookRide(userId, rides);
	}

	@RequestMapping(value = "/rides", method = RequestMethod.PUT)
	public String createRide(@RequestBody List<Rides> rides) throws RidesException {
		return ridesService.createRide(rides);

	}

}

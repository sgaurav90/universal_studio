package com.universalstudio.rides.repository;

import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universalstudio.rides.model.Rides;

public interface RidesRepository extends JpaRepository<Rides, Integer> {

	public Rides findByRideIdAndStartTime(Integer rideId, Time startTime);

	public List<Rides> findByRideId(Integer rideId);

}

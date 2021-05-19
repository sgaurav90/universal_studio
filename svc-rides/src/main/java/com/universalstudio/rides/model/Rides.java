package com.universalstudio.rides.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author gauravsingh
 *
 */

@Entity
public class Rides {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "RIDE_ID")
	private Integer rideId;

	@Column(name = "START_TIME")
	private Time startTime;

	@Column(name = "RIDE_NAME")
	private String rideName;

	@Column(name = "RIDE_CAPACITY")
	private Integer rideCapacity;

	public Integer getRideId() {
		return rideId;
	}

	public void setRideId(Integer rideId) {
		this.rideId = rideId;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public String getRideName() {
		return rideName;
	}

	public void setRideName(String rideName) {
		this.rideName = rideName;
	}

	public Integer getRideCapacity() {
		return rideCapacity;
	}

	public void setRideCapacity(Integer rideCapacity) {
		this.rideCapacity = rideCapacity;
	}

}

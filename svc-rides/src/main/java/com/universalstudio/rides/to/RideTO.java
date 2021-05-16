package com.universalstudio.rides.to;

public class RideTO {
	
	private Integer rideId;
	private String rideName;
	private String startTime;
	private Integer seatAvailable;
	private String waitTime;
	
	
	public Integer getRideId() {
		return rideId;
	}
	public void setRideId(Integer rideId) {
		this.rideId = rideId;
	}
	public String getRideName() {
		return rideName;
	}
	public void setRideName(String rideName) {
		this.rideName = rideName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Integer getSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(Integer seatAvailable) {
		this.seatAvailable = seatAvailable;
	}
	public String getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}

}

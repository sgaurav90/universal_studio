package com.universalstudio.rides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universalstudio.rides.model.UserRideDetails;

@Repository
public interface UserRideDetailsRepository extends JpaRepository<UserRideDetails, Integer> {

}

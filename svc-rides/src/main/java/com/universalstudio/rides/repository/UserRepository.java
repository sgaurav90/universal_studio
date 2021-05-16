package com.universalstudio.rides.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universalstudio.rides.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAll();

}

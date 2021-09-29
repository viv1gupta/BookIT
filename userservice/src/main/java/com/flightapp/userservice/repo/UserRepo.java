package com.flightapp.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.userservice.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}

package com.flightapp.airlineservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.airlineservice.entities.Airlines;

@Repository
public interface AirlineRepository extends JpaRepository<Airlines, String> {

}

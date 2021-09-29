package com.flightapp.airlineservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.airlineservice.entities.Flights;

@Repository
public interface FlightRepository extends JpaRepository<Flights, String>{

}

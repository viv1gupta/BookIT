package com.flightapp.airlineservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.airlineservice.entities.Flights;
import com.flightapp.airlineservice.repositories.AirlineRepository;

@Service
public class FlightService {

	@Autowired
	AirlineRepository airlineRepository;

	public void registerFlights(Flights airlines) {
		// TODO Auto-generated method stub
		
	}

	public Flights update(Flights flights) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteFlights(Flights flights) {
		// TODO Auto-generated method stub
		
	}

	public List<Flights> getAllFlights() {
		// TODO Auto-generated method stub
		return null;
	}

	public Flights getFlightbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

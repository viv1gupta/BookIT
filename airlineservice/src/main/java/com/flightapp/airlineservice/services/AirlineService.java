package com.flightapp.airlineservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.airlineservice.entities.Airlines;
import com.flightapp.airlineservice.repositories.AirlineRepository;

@Service
public class AirlineService {

	@Autowired
	AirlineRepository airlinerepo;

	public Airlines getAirlinebyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Airlines> getAllAirlines() {
		// TODO Auto-generated method stub
		return null;
	}

	public Airlines update(Airlines airlines) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registerAirline(Airlines airlines) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAirline(Airlines airlines) {
		// TODO Auto-generated method stub
		
	}

	
}

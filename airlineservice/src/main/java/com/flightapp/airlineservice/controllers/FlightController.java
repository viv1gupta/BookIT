package com.flightapp.airlineservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.airlineservice.entities.Flights;
import com.flightapp.airlineservice.services.FlightService;


@RestController
public class FlightController {

	@Autowired
	FlightService flightService;
	
	Logger logger = LoggerFactory.getLogger(AirlineController.class); 
	
	@PostMapping("/airline/register")
	public Flights airlineRegistration(@RequestBody Flights airlines)
	{
		flightService.registerFlights(airlines);
		return airlines;
	}
	
	@PutMapping("/airline/add")
	public Flights updateAirline(@RequestBody Flights flights)
	{
		 return flightService.update(flights);
	}
	
	@DeleteMapping("/airline/remove")
	public ResponseEntity<String> deleteAirline(@RequestBody Flights flights)
	{
		flightService.deleteFlights(flights);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/airlines")
	public List<Flights> allAirLines()
	{
		
		return flightService.getAllFlights();
	}
	
	@GetMapping("/airlines/{id}")
	public Flights getAirline(@RequestParam String id)
	{
		System.out.println(id);
		return flightService.getFlightbyid(id);
	}
}

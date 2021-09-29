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

import com.flightapp.airlineservice.entities.Airlines;
import com.flightapp.airlineservice.services.AirlineService;

@RestController
public class AirlineController {
	@Autowired
	AirlineService airlineService;
	
	Logger logger = LoggerFactory.getLogger(AirlineController.class); 
	
	@PostMapping("/airline/register")
	public Airlines airlineRegistration(@RequestBody Airlines airlines)
	{
		airlineService.registerAirline(airlines);
		return airlines;
	}
	
	@PutMapping("/airline/add")
	public Airlines updateAirline(@RequestBody Airlines airlines)
	{
		 return airlineService.update(airlines);
	}
	
	@DeleteMapping("/airline/remove")
	public ResponseEntity<String> deleteAirline(@RequestBody Airlines airlines)
	{
		airlineService.deleteAirline(airlines);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/airlines")
	public List<Airlines> allAirLines()
	{
		
		return airlineService.getAllAirlines();
	}
	
	@GetMapping("/airlines/{id}")
	public Airlines getAirline(@RequestParam String id)
	{
		System.out.println(id);
		return airlineService.getAirlinebyid(id);
	}
	
}

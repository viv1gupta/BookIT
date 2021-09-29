package com.flightapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Schedule;
import com.flightapp.services.ScheduleService;

@RestController
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;
	
	Logger logger = LoggerFactory.getLogger(ScheduleController.class); 
	
	
	@PostMapping("/Schedule/new")
	public Schedule userRegistration(@RequestBody Schedule user)
	{
		scheduleService.newSchedule(user);
		return user;
	}
	
	@PutMapping("/schedule/update")
	public Schedule updateSchedule(@RequestBody Schedule user) 
	{
		 return scheduleService.updateSchedule(user);
	}
	
	@DeleteMapping("/schedule/remove")
	public ResponseEntity<String> deleteSchedule(@PathVariable int id)
	{
		scheduleService.deleteSchedule(id);
		 return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/schedules")
	public List<Schedule> allUsers()
	{
		
		return scheduleService.getSchedules();
	}
	
	@GetMapping("/schedule/{id}")
	public Schedule user(@RequestParam String id)
	{
		System.out.println(id);
		return scheduleService.getSchedule(id);
	}
}

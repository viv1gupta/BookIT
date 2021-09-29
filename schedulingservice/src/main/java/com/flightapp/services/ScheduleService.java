package com.flightapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entities.Schedule;
import com.flightapp.repositories.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	ScheduleRepository repository;

	public void newSchedule(Schedule user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteSchedule(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Schedule> getSchedules() {
		// TODO Auto-generated method stub
		return null;
	}

	public Schedule getSchedule(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Schedule updateSchedule(Schedule user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

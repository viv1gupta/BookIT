package com.flightapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

}

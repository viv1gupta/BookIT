package com.flightapp.bookingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.bookingservice.entities.Booking;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, String> {

}

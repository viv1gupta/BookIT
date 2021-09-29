package com.flightapp.bookingservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.bookingservice.repositories.BookingsRepository;

@Service
public class BookingService {

	@Autowired
	BookingsRepository bookingsRepository;
}

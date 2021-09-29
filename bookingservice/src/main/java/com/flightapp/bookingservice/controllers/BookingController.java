package com.flightapp.bookingservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.bookingservice.services.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;
}

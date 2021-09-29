package com.flightapp.bookingservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.bookingservice.services.TicketService;

@RestController
public class TicketController {

	@Autowired
	TicketService service;
}

package com.flightapp.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flightapp.userservice.exceptions.InvalidUserPassException;
import com.flightapp.userservice.exceptions.UserAlreadyExistsException;
import com.flightapp.userservice.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserExceptionController {

	Logger logger = LoggerFactory.getLogger(UserExceptionController.class); 
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> notfound()
	{
		logger.debug("User not found exception thrown "+ System.currentTimeMillis());
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	 
	@ExceptionHandler(InvalidUserPassException.class)
	public ResponseEntity<String> invalidUserPass() 
	{
		logger.debug("User invalid password exception thrown "+ System.currentTimeMillis());
		return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String> invalidUser() 
	{
		logger.debug("User already Exists "+ System.currentTimeMillis());
		return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	}
}

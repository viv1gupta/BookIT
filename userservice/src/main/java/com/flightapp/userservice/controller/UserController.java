package com.flightapp.userservice.controller;

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

import com.flightapp.userservice.entities.User;
import com.flightapp.userservice.exceptions.InvalidUserPassException;
import com.flightapp.userservice.exceptions.UserAlreadyExistsException;
import com.flightapp.userservice.exceptions.UserNotFoundException;
import com.flightapp.userservice.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	Logger logger = LoggerFactory.getLogger(UserController.class); 
	
	@PostMapping("/user/login")
	public User userLogin(@RequestBody User user) throws UserNotFoundException, InvalidUserPassException
	{
		
		User value= userService.validateUser(user);	
		return value;
	}
	
	@PostMapping("/admin/login")
	public User AdminLogin(@RequestBody User user) throws InvalidUserPassException, UserNotFoundException
	{
		return userService.validateAdmin(user);
	}
	
	@PostMapping("/user/register")
	public User userRegistration(@RequestBody User user) throws UserAlreadyExistsException
	{
		userService.registerUser(user);
		return user;
	}
	
	@PutMapping("/user/update")
	public User updateUser(@RequestBody User user) throws UserNotFoundException
	{
		 return userService.update(user);
	}
	
	@DeleteMapping("/user/unregister")
	public ResponseEntity<String> deleteUser(@RequestBody User user) throws UserNotFoundException
	{
		 userService.deleteUser(user);
		 return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/users")
	public List<User> allUsers() throws UserNotFoundException
	{
		
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User user(@RequestParam String id)
	{
		System.out.println(id);
		return userService.getUser(id);
	}
	
//	@RequestMapping("/error")
//	public String error(@RequestBody User user)
//	{
//		
//		return "Hey!Looks like a wrong URL";
//	}
}

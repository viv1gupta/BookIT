package com.flightapp.userservice.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import com.flightapp.userservice.entities.User;
import com.flightapp.userservice.exceptions.InvalidUserPassException;
import com.flightapp.userservice.exceptions.UserAlreadyExistsException;
import com.flightapp.userservice.exceptions.UserNotFoundException;
import com.flightapp.userservice.repo.UserRepo;

@Service
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
public class UserService {
	
	@Autowired
	UserRepo repo;
	
	@Value("${admin.username}")
	String adminName;
	
	@Value("${admin.password}")
	String adminPass;
	
	String obfuscated = "**obfuscated**"; 
	
	Logger logger = LoggerFactory.getLogger(UserService.class); 
	
	
	public User validateAdmin(User user) throws InvalidUserPassException, UserNotFoundException
	{
		if(user.getEmailId().equals(adminName))
		{	
			if(match(user.getPass()))
			{
				User u = new User();
				u.setName(adminName);
				u.setPass(obfuscated);
				logger.debug("Admin Logged in....");
				return u;
			}
			else
			{
				logger.debug("Admin access denied form server....");
				throw new InvalidUserPassException();
			}
		}
		else
		{
			System.out.println( user.getEmailId()+" "+adminName+".......");
			logger.debug(" access denied form server, usermane doesn't match....");
			throw new UserNotFoundException();
		}
	}

	public  User validateUser(User user) throws UserNotFoundException, InvalidUserPassException
	{	
		
		if(repo.existsById(user.getEmailId()))
		{
			User u=repo.getById(user.getEmailId());
			if(u.getPass().equals(user.getPass()))
			{
				u.setPass(obfuscated);
				return u;
			}
			else
			{
				throw new InvalidUserPassException();
			}
		}
		else
		{
			throw new UserNotFoundException();
		}
		
	}
	
	public  User deleteUser(User user) throws UserNotFoundException
	{	
		if(repo.existsById(user.getEmailId()))
		{
			User u=repo.getById(user.getEmailId());
			if(u.getEmailId().equals(user.getEmailId()) && u.getPass().equals(user.getPass()) )
			{
				repo.deleteById(user.getEmailId());
			}
			else
			{
				throw new UserNotFoundException();
			}
		}
		else
		{
			throw new UserNotFoundException();
		}
		
		return user;
		
	}
	
	public  User registerUser(User user) throws UserAlreadyExistsException
	{	
		if(!repo.existsById(user.getEmailId()))
		{
			repo.save(user);
			user.setPass(obfuscated);
		}
		else
		{
			throw new UserAlreadyExistsException();
		}
		return user;
		
	}
	
	public  User update(User user) throws UserNotFoundException
	{	
		if(repo.existsById(user.getEmailId()))
		{
			User u=repo.getById(user.getEmailId());
			user.setEmailId(u.getEmailId());
			user.setPass(u.getPass());
			repo.save(user);
		}
		else
		{
			throw new UserNotFoundException();
		}
		return user;
		
	}
	
	
	public boolean match(String compare){
	    String md5 = null;
	    try{
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(compare.getBytes());
	        byte[] digest = md.digest();
	        md5 = new BigInteger(1, digest).toString(16);
	        return md5.equals(adminPass);

	    } catch (NoSuchAlgorithmException e) {
	        return false;
	    }
	}
	
	public List<User> getAllUsers() throws UserNotFoundException
	{
		List<User> list= repo.findAll();
		if(list==null||list.size()==0)
		{
			throw new UserNotFoundException();
		}
		return list;
	}
	
	public User getUser(String email)
	{
		return repo.findById(email).orElse(null);
	}
	
}

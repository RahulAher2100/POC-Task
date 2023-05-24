package com.neosoft.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.neosoft.microservice.entity.Contact;
import com.neosoft.microservice.entity.User;
import com.neosoft.microservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restT;
	
	@GetMapping("/getSingle/{userId}")
	public User getUser(@PathVariable("userId") Long userId)
	{
		User user=this.userService.getUser(userId);
		
		String url="http://contact-service/contact/user/"+user.getUserId();
		
		 List contact=restT.getForObject(url,List.class);
		
		user.setContacts(contact);
		
		return user;
	}

}

package com.neosoft.microservice.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.neosoft.microservice.entity.User;
import com.neosoft.microservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	List<User>list=List.of(
			new User(111L,"Rahul","860082778"),
			new User(222L,"Kiran","990982778"),
			new User(333L,"Rohit","872382778"),
			new User(444L,"Kuljit","876582778")
			);

	@Override
	public User getUser(Long userId) {
		
		
		return list.stream().filter(user -> user.getUserId().equals(userId)).findAny().orElse(null);
	}
	
	
	
	
	

}

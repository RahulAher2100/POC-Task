package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class JwtDemoApplication {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initUser() {
		
		List<User> users=Stream.of(
				new User(1,"Rahul","rahul21","rahul@gmail.com"),
				new User(2,"Rohit","rohit21","rohit@gmail.com"),
				new User(3,"Rajat","rajat21","rajat@gmail.com"),
				new User(4,"Sagar","sagar21","sagar@gmail.com"),
				new User(5,"Pawan","pawan21","pawan@gmail.com")
		).collect(Collectors.toList());
		
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}

}

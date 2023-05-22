package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthenticationRequest;
import com.example.demo.util.JwtUtil;

@RestController
public class UserController {
	
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcome() {
		
		
		return "Welcome to Spring Security";
	}
	
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
		
		try {
		authenticationManager.authenticate(

				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		}catch(Exception ex) {
			
			throw new Exception("Invalid UserName/Password");
			
		}
		
		return jwtUtil.generateToken(authRequest.getUserName());
		
		
	}

}

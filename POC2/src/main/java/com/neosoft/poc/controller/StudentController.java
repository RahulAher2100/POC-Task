package com.neosoft.poc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.poc.config.JwtUtil;
import com.neosoft.poc.config.MyUserDetailsService;
import com.neosoft.poc.entity.AuthenticationRequest;
import com.neosoft.poc.entity.AuthenticationResponse;
import com.neosoft.poc.entity.Student;
import com.neosoft.poc.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@PostMapping("/insert")
	public ResponseEntity<Student>createStudent(@Valid @RequestBody Student student)
	{
		
		Student stud=this.studentservice.insertData(student);
		
		return new ResponseEntity<Student>(stud,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>>getData()
	{
		List<Student>stud=this.studentservice.getAllStudent();
		
		return new ResponseEntity<List<Student>>(stud,HttpStatus.OK);
	}
	
	
	@GetMapping("/findByStudentId/{studentId}")
	public ResponseEntity<Student>getById(@PathVariable("studentId") int studentId)
	{
	   Student stud=this.studentservice.getStudentById(studentId);
	   
	   return new ResponseEntity<Student>(stud,HttpStatus.OK);
	}
	
	
	@PostMapping("/token")
	public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		
		catch(BadCredentialsException e){
			
			throw new Exception("Invalid Username or Password",e);
			
		}
		
		final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	    
		final String jwt=jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
				
	}
	
	

}

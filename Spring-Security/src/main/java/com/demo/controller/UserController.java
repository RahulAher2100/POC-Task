package com.demo.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.common.UserConstants;
import com.demo.entity.User;
import com.demo.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	
	@PostMapping("/join")
	public String joinGroup(@RequestBody User user) {
		
		user.setRoles(UserConstants.DEFAULT_ROLE);
		
		String enCryptedPassword=passwordEncoder.encode(user.getPassword());
		user.setPassword(enCryptedPassword);
		userRepository.save(user);
		
		return "Hi.." +user.getUserName()+" Welcome to Group";
		
	}
	
	
	// If LoggedIn User is ADMIN then ADMIN Or MODERATOR
	// If LoggedIn User is MODERATOR then  MODERATOR
	@GetMapping("/access/{userId}/{userRole}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODIRATOR')")
	public String getAccessToUser(@PathVariable int userId, @PathVariable String userRole, Principal principal) {
		
		User user=userRepository.findById(userId).get();
		List<String>activeRoles=getRolesByLoggedInUser(principal);
		String newRoles="";
		if(activeRoles.contains(userRole)) {
			newRoles=user.getRoles()+","+userRole;
			user.setRoles(newRoles);
		}
		userRepository.save(user);
		
		return "Hi.."+ user.getUserName()+" new Role Assign to you By "+principal.getName();
	}
	
	private List<String> getRolesByLoggedInUser(Principal principal){
		String roles=getLoggedInUser(principal).getRoles();
		List<String> assignRoles=Arrays.stream(roles.split(",")).collect(Collectors.toList());
		
		if(assignRoles.contains("ROLE_ADMIN")) {
			return Arrays.stream(UserConstants.ADMIN_ACCESS).collect(Collectors.toList());
		}
		
		if(assignRoles.contains("ROLE_MODITAOR")) {
			return Arrays.stream(UserConstants.MODITAOR_ACCESS).collect(Collectors.toList());
		}
		
		
		return Collections.emptyList();
		
	}
	
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<User>loadUser(){
		
		return userRepository.findAll();
	}
	
	@GetMapping("/test")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String testUseraccess() {
		
		return "User can only access this ! ";
		
	}
	
	
	private User getLoggedInUser(Principal principal) {

		return userRepository.findByUserName(principal.getName()).get();
    }
	
	
	
	
}

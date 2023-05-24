package com.neosoft.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.microservice.entity.Contact;
import com.neosoft.microservice.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	
	@Autowired
	private ContactService contactService;
	
	
	@PostMapping("/insert")
	public ResponseEntity<Contact>insertData(@RequestBody Contact contact)
	{
		Contact conct=this.contactService.saveData(contact);
		
		return new ResponseEntity<Contact>(conct,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<Contact>getSingle(@PathVariable("userId") int userId)
	{
		Contact conct=this.contactService.getContactById(userId);
		
		return new ResponseEntity<Contact>(conct,HttpStatus.OK);
	}
}

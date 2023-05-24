package com.neosoft.microservice.service;

import com.neosoft.microservice.entity.Contact;

public interface ContactService {

	Contact saveData(Contact contact);

	Contact getContactById(int userId);
	

	
	
	

}

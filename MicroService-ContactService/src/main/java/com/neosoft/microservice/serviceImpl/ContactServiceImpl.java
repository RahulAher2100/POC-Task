package com.neosoft.microservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.microservice.entity.Contact;
import com.neosoft.microservice.repository.ContactRepository;
import com.neosoft.microservice.service.ContactService;


@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact saveData(Contact contact) {
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}

	@Override
	public Contact getContactById(int userId) {
		// TODO Auto-generated method stub
		return contactRepository.findById(userId).get();
	}

	
	

}

package com.neosoft.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.microservice.entity.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	Object findByUserId(int userId);

}

package com.neosoft.poc.service;

import java.util.List;

import javax.validation.Valid;

import com.neosoft.poc.entity.User;

public interface UserService {

	User createUser(@Valid User user);

	List<User> getAllUser();

	List<User> getByFname(String firstName);

	String hardDeleteUser(int userId);

	List<User> softDeleteUser(int userId);

}

package com.neosoft.poc.controller;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.poc.entity.User;
import com.neosoft.poc.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping("/createUser")
	public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {
		User saveUser = this.userservice.createUser(user);

		return new ResponseEntity<User>(saveUser, HttpStatus.OK);

	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAll() {

		List<User> user = this.userservice.getAllUser();

		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	@GetMapping("/getUserByFirstName/{firstName}")
	public ResponseEntity<List<User>> getUser(@PathVariable("firstName") String firstName) {

		List<User> user = this.userservice.getByFname(firstName);

		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	@DeleteMapping("/hardDeleteByUserId/{userId}")
	public ResponseEntity<String> hardDelete(@PathVariable("userId") int userId) {

		return new ResponseEntity<String>(userservice.hardDeleteUser(userId), HttpStatus.OK);
	}

	@DeleteMapping("/softDeleteByUserId/{userId}")
	public ResponseEntity<List<User>> softDelete(@PathVariable("userId") int userId) {

		List<User> user = this.userservice.softDeleteUser(userId);

		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	@GetMapping("/sortUserByBirthDate")
	public ResponseEntity<List<User>> getBirthdate() {

		List<User> user = this.userservice.getAllUser();

		Comparator<User> comp = new Comparator<User>() {

			DateFormat date = new SimpleDateFormat("dd-mm-yyyy");

			@Override
			public int compare(User u1, User u2) {
				Date d1 = null;
				Date d2 = null;

				try {

					d1 = date.parse(u1.getBirthDate());

					d2 = date.parse(u2.getBirthDate());
				} catch (ParseException e) {
					e.printStackTrace();
				}

				return d1.compareTo(d2);
			}
		};

		Collections.sort(user, comp);

		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	@GetMapping("/sortUserByJoinDate")
	public ResponseEntity<List<User>> getJoindate() {

		List<User> user = this.userservice.getAllUser();

		Comparator<User> comparator = new Comparator<User>() {

			DateFormat date = new SimpleDateFormat("dd-mm-yyyy");

			@Override
			public int compare(User u1, User u2) {
				Date d1 = null;
				Date d2 = null;

				try {

					d1 = date.parse(u1.getJoinDate());

					d2 = date.parse(u2.getJoinDate());
				} catch (ParseException e) {
					e.printStackTrace();
				}

				return d1.compareTo(d2);
			}
		};

		Collections.sort(user, comparator);

		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

}

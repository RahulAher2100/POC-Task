package com.neosoft.poc.serviceIMPL;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.poc.entity.User;
import com.neosoft.poc.repository.UserRepository;
import com.neosoft.poc.service.UserService;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private UserRepository userrepository;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub

		return userrepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub

		List<User> user = userrepository.findAll();

		// System.out.println("Getting Data from DB:"+user);

		return user;

	}

	@Override
	public List<User> getByFname(String firstName) {
		// TODO Auto-generated method stub
		List<User> user = userrepository.getByFirstName(firstName);

		return user;
	}

	@Override
	public String hardDeleteUser(int userId) {
		// TODO Auto-generated method stub

		userrepository.deleteById(userId);

		return "Record Deleted Successfully..";
	}

	@Override
	public List<User> softDeleteUser(int userId) {
		// TODO Auto-generated method stub

		User user = userrepository.findById(userId).get();

		user.setActive(false);

		userrepository.save(user);

		List<User> userlist = userrepository.findAll();

		List<User> list = new ArrayList<>();

		for (User usr : userlist) {
			if (usr.isActive() == true) {
				list.add(user);
			}
		}
		return list;
	}

}

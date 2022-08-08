package com.neosoft.poc.serviceImplTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.stream;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.neosoft.poc.entity.User;
import com.neosoft.poc.repository.UserRepository;
import com.neosoft.poc.serviceIMPL.UserServiceIMPL;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	private UserServiceIMPL userService;

	@Mock
	private UserRepository userRepository;

	@BeforeEach
	public void setup() throws Exception {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveUser() {

		User user = new User(12, "Sarang", "Raut", "sarang@gmail.com", "sarang", "sarang@21", "411675", "16-01-1997",
				"21-09-2019", true);

		this.userService.createUser(user);

		verify(userRepository, times(1)).save(user);

	}

	@Test
	public void testAllUser() {

		when(userRepository.findAll()).thenReturn(Stream.of(
				new User(9, "Vittal", "Dhamak", "viithu@gmail.com", "vitthal", "vithu@24", "413876", "04-10-1991",
						"12-12-2009", true),
				new User(10, "Dinesh", "Gupta", "dinesh@gmailcom", "dinesh", "dinesh@21", "455678", "13-10-1992",
						"26-11-2007", true))
				.collect(Collectors.toList()));

		assertEquals(2, userService.getAllUser().size());
	}

	@Test
	public void testGetByFnameUser() {

		String fname = "Saurabh";
		User user = new User(14, "Saurabh", "Raut", "saurabh@gmail.com", "saurabh", "saurabh@21", "411611",
				"16-01-1997", "21-09-2019", true);

		userService.getByFname(fname);

		Assert.assertEquals(user.getFirstName(), fname);
	}

	@Test
	public void testHardDeleteUser() {

		User user = new User(13, "Sanjay", "Rana", "sanjay@gmail.com", "sanjay", "sanjay@21", "414375", "18-11-2001",
				"28-03-2015", true);

		userService.hardDeleteUser(13);

		verify(userRepository, times(1)).deleteById(13);
	}

	@Test
	public void testSoftDeleteUser() {

		User user = new User(17, "Suyog", "Sapkal", "suyog@gmail.com", "suyog", "suyog@21", "418875", "28-12-2002",
				"18-05-2019", true);

		userService.hardDeleteUser(17);

		verify(userRepository, times(1)).deleteById(17);
	}

}

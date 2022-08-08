package com.neosoft.poc.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.neosoft.poc.entity.User;
import com.neosoft.poc.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Order(1)
	public void testSaveUser() {
		User user = User.builder().firstName("Arnav").lastName("Singh").email("arnav@gmail.com").userName("arnav")
				.password("arnav21").pincode("411765").birthDate("15-01-1992").joinDate("25-03-2009").isActive(true)
				.build();

		userRepository.save(user);

		Assertions.assertThat(user.getUserId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void testAllUsers() {

		List<User> user = userRepository.findAll();

		assertThat(user).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testSingleUser() {
		User user = userRepository.findById(2).get();

		assertEquals("Rahul", user.getFirstName());
	}

	@Test
	@Order(4)
	public void testDeleteUser() {
		userRepository.deleteById(22);

		assertThat(userRepository.existsById(22)).isFalse();
	}

}

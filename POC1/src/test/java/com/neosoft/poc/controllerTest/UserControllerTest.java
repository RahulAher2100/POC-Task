package com.neosoft.poc.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.neosoft.poc.controller.UserController;
import com.neosoft.poc.entity.User;
import com.neosoft.poc.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {

	@MockBean
	private UserService userservice;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	public void testCreateUser() throws Exception {
		User user = new User(11, "Yogesh", "Khanna", "yogesh@gmail.com", "yogesh", "yogesh@21", "432156", "13-11-1999",
				"17-01-2005", true);

		when(userservice.createUser(user)).thenReturn(user);

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/userapi/createUser");

		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		assertEquals(user, userservice.createUser(user));

	}

	@Test
	@Order(2)
	public void testGetAllUsers() throws Exception {
		when(userservice.getAllUser()).thenReturn(Stream.of(
				new User(9, "Vittal", "Dhamak", "viithu@gmail.com", "vitthal", "vithu@24", "413876", "04-10-1991",
						"12-12-2009", true),
				new User(10, "Dinesh", "Gupta", "dinesh@gmailcom", "dinesh", "dinesh@21", "455678", "13-10-1992",
						"26-11-2007", true))
				.collect(Collectors.toList()));

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/userapi/getAllUser");

		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		assertEquals(2, userservice.getAllUser().size());
	}

	@Test
	@Order(3)
	public void testUserByFirstName() throws Exception {
		String fname = "Rahul";

		when(userservice.getByFname(fname)).thenReturn(Stream.of(new User(10, "Karan", "Sinha", "karan@gmail.com",
				"karan@21", "karan21", "456789", "12-11-2000", "16-09-2007", true)).collect(Collectors.toList()));

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/userapi/getUserByFirstName");

		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		assertEquals(1, userservice.getByFname(fname).size());
	}

	@Test
	@Order(4)
	public void testHardDeleteUser() throws Exception {
		User user = new User(11, "Yogesh", "Khanna", "yogesh@gmail.com", "yogesh", "yogesh@21", "432156", "13-11-1999",
				"17-01-2005", true);

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/userapi/hardDeleteByUserId/11");

		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		verify(userservice, times(1)).hardDeleteUser(11);
	}

	@Test
	@Order(5)
	public void testSoftDeleteUser() throws Exception {
		User user = new User(13, "Shivaji", "Gujar", "shivaji@gmail.com", "shivaji", "shivaji@21", "432143",
				"11-10-1991", "12-09-2015", true);

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/userapi/softDeleteByUserId/13");

		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		verify(userservice, times(1)).softDeleteUser(13);
	}

}

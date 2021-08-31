package com.qa.choonz.integrationtests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.choonz.persistence.domain.Users;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:test-data.sql",
		"classpath:test-schema.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class UserControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;

	@Test
	@Order(1)
	void testCreate() throws Exception {

		Users user = new Users(1L, "Dave", "davealg", "davidalgie");

		String userAsJSON = this.mapper.writeValueAsString(user);

		RequestBuilder mockRequest = post("/users/create").contentType(MediaType.APPLICATION_JSON).content(userAsJSON);

		Users userInDb = new Users(1L, "Dave", "davealg", "davidalgie");

		String userInDbAsJSON = this.mapper.writeValueAsString(userInDb);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(userInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testReadOneUser() throws Exception {

		RequestBuilder mockRequest = get("/users/read/1");

		Users userInDb = new Users(1L, "Dave", "davealg", "davidalgie");

		String userInDbAsJSON = this.mapper.writeValueAsString(userInDb);

		ResultMatcher matchStatus = status().isAccepted();

		ResultMatcher matchBody = content().json(userInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testReadAllUsers() throws Exception {
		// Build mock request
		RequestBuilder mockRequest = get("/users/read");

		// Create user object that should resemble the existing one on database
		Users user = new Users(1L, "Dave", "davealg", "davidalgie");

		List<Users> usersInDb = new ArrayList<>();
		usersInDb.add(user);

		String usersInDbAsJSON = this.mapper.writeValueAsString(usersInDb);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(usersInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testUpdateUser() throws Exception {

		Users updatedUser = new Users("Sirish", "sirsho", "sirishk");

		String updatedUserAsJSON = this.mapper.writeValueAsString(updatedUser);

		RequestBuilder mockRequest = put("/users/update/1").contentType(MediaType.APPLICATION_JSON)
				.content(updatedUserAsJSON);

		Users updatedUserInDb = new Users(1L, "MichealNew", "password123New", "polkadotNew");

		String updatedUserInDbAsJSON = this.mapper.writeValueAsString(updatedUserInDb);

		ResultMatcher matchStatus = status().isAccepted();

		ResultMatcher matchBody = content().json(updatedUserInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}
	@Test
	void testDeleteUser() throws Exception {
	
		RequestBuilder mockRequest = delete("/users/delete/1");
		
	
		ResultMatcher matchStatus = status().isNoContent();
		
		
		this.mock.perform(mockRequest).andExpect(matchStatus);
	}

}

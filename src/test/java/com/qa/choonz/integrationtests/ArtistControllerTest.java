package com.qa.choonz.integrationtests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.rest.dto.ArtistDTO;





@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testdata.sql", "classpath:testschema.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ArtistControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;
	
	private final Artist artist = new Artist("Kirk Hammett");
	
	private final Artist artistWithId = new Artist(1L, "Kirk Hammett");
	
	@Test
	void testPost() throws Exception {

		Artist artist = new Artist ("Run a test");

		String ToDoAsJSON = this.mapper.writeValueAsString(artist);

		RequestBuilder mockRequest = post("/artists/create").contentType(MediaType.APPLICATION_JSON).content(ToDoAsJSON);

		Artist savedToDo = new Artist (2L, "Kirk Hammett");

		String savedToDoAsJSON = this.mapper.writeValueAsString(savedToDo);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(savedToDoAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}
	@Test
	public void testReadOne() throws Exception {
		this.mock.perform(get("/artists/read/1")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(artistWithId)));
	}
	
	

	@Test
	void testDeleteArtist() throws Exception {

		RequestBuilder mockRequest = delete("/artists/delete/1");

		ResultMatcher matchStatus = status().isNoContent();

		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
}

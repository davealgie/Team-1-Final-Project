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
@Sql(scripts = { "classpath:test-schema.sql",
		"classpath:test-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ArtistControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;


	@Test
	void testPost() throws Exception {

		Artist artist = new Artist("Kirk John", new ArrayList<>());

		String ToDoAsJSON = this.mapper.writeValueAsString(artist);

		RequestBuilder mockRequest = post("/artists/create").contentType(MediaType.APPLICATION_JSON)
				.content(ToDoAsJSON);

		Artist savedToDo = new Artist(2L, "Kirk John", new ArrayList<>());


		String savedToDoAsJSON = this.mapper.writeValueAsString(savedToDo);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(savedToDoAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}


	@Test
	void testReadAllArtists() throws Exception {

		RequestBuilder mockRequest = get("/artists/read");

		Artist artist = new Artist(1L, "Kirk Hammett", new ArrayList<>());

		List<Artist> artistsInDb = new ArrayList<>();
		artistsInDb.add(artist);

		String artistsInDbAsJSON = this.mapper.writeValueAsString(artistsInDb);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(artistsInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	

	@Test
	void testReadOne() throws Exception {
		ArtistDTO expected = new ArtistDTO(1L, "Kirk Hammett", new ArrayList<Album>());
		String expectedJSON = mapper.writeValueAsString(expected);

		RequestBuilder mockRequest = get("/artists/read/1");

		Artist artistInDb = new Artist(1L, "Kirk Hammett", new ArrayList<>());

		String artistInDbAsJSON = this.mapper.writeValueAsString(artistInDb);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(artistInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}


	@Test
	void testUpdateArtist() throws Exception {

		Artist updatedArtist = new Artist("James Hetfield", new ArrayList<>());

		String updatedArtistAsJSON = this.mapper.writeValueAsString(updatedArtist);

		RequestBuilder mockRequest = post("/artists/update/1").contentType(MediaType.APPLICATION_JSON).content(updatedArtistAsJSON);

		Artist updatedArtistInDb = new Artist(1L, "James Hetfield", new ArrayList<>());

		String updatedArtistInDbAsJSON = this.mapper.writeValueAsString(updatedArtistInDb);

		ResultMatcher matchStatus = status().isAccepted();

		ResultMatcher matchBody = content().json(updatedArtistInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testDeleteArtist() throws Exception {

		RequestBuilder mockRequest = delete("/artists/delete/1");

		ResultMatcher matchStatus = status().isNoContent();

		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
}

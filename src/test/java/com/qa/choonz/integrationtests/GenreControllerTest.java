package com.qa.choonz.integrationtests;

import org.springframework.boot.test.context.SpringBootTest;

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

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.choonz.persistence.domain.Genre;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
<<<<<<< HEAD
@Sql(scripts = { "classpath:testschema.sql",
		"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
=======
>>>>>>> f06a13250daad75a45b3cefa3bf84cf9fb9a4cec
public class GenreControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreateGenre() throws Exception {

		Genre genre = new Genre(1L, "Rock", "lead guitar");

		String genreAsJSON = this.mapper.writeValueAsString(genre);

		RequestBuilder mockRequest = post("/genres/create").contentType(MediaType.APPLICATION_JSON)
				.content(genreAsJSON);

		Genre genreInDb = new Genre(2L, "Rock", "lead guitar");

		String genreInDbAsJSON = this.mapper.writeValueAsString(genreInDb);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(genreInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testReadOneGenre() throws Exception {

		RequestBuilder mockRequest = get("/genres/read/1");

		Genre genreInDb = new Genre(1L, "Rock", "lead guitar");

		String genreInDbAsJSON = this.mapper.writeValueAsString(genreInDb);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(genreInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testReadAllGenres() throws Exception {

		RequestBuilder mockRequest = get("/genres/read");

		Genre genre = new Genre(1L, "Rock", "lead guitar");

		List<Genre> genresInDb = new ArrayList<>();
		genresInDb.add(genre);

		String genresInDbAsJSON = this.mapper.writeValueAsString(genresInDb);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(genresInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testUpdateGenre() throws Exception {

		Genre updatedGenre = new Genre(1L, "Smooth Rock", "smooth guitar");

		String updatedGenreAsJSON = this.mapper.writeValueAsString(updatedGenre);

		RequestBuilder mockRequest = put("/genres/update/1").contentType(MediaType.APPLICATION_JSON)
				.content(updatedGenreAsJSON);

		Genre updatedGenreInDb = new Genre(1L, "Light Rock", "light guitar");

		String updatedGenreInDbAsJSON = this.mapper.writeValueAsString(updatedGenreInDb);

		ResultMatcher matchStatus = status().isAccepted();

		ResultMatcher matchBody = content().json(updatedGenreInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testDeleteGenre() throws Exception {

		RequestBuilder mockRequest = delete("/genres/delete/1");

		ResultMatcher matchStatus = status().isNoContent();

		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
}

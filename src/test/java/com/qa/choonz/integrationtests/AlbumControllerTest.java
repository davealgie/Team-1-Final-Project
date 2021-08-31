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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.domain.Track;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:test-schema.sql",
		"classpath:test-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class AlbumControllerTest {
	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreateAlbum() throws Exception {

		Artist artist = new Artist(1L, "Kirk Hammett", new ArrayList<>());

		Album album = new Album(2L, "Kill em all", artist, "Red");

		String albumAsJSON = this.mapper.writeValueAsString(album);

		RequestBuilder mockRequest = post("/albums/create").contentType(MediaType.APPLICATION_JSON)
				.content(albumAsJSON);
		Album albumInDb = new Album(2L, "Kill em all", artist, "Red");

		String albumInDbAsJSON = this.mapper.writeValueAsString(albumInDb);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(albumInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testReadOne() throws Exception {
		RequestBuilder mockRequest = get("/albums/read/1");

		Artist artist = new Artist(1L, "Kirk Hammett", new ArrayList<>());

		Album album = new Album(1L, "Black album", artist, "Snake");

		String albumAsJSON = this.mapper.writeValueAsString(album);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(albumAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);

	}

	@Test
	void testReadAll() throws Exception {
		RequestBuilder mockRequest = get("/albums/read");

		Artist artist = new Artist(1L, "Kirk Hammett", new ArrayList<>());

		Album album = new Album(1L, "Black album", artist, "Snake");

		List<Album> albumsInDb = new ArrayList<>();

		albumsInDb.add(album);

		String albumsInDbAsJSON = this.mapper.writeValueAsString(albumsInDb);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(albumsInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testUpdate() throws Exception {
		Artist artist = new Artist(1L, "Kirk Hammett", new ArrayList<>());

		Album newAlbum = new Album(1L, "Kill em all", artist, "Red");

		String updatedAlbumAsJSON = this.mapper.writeValueAsString(newAlbum);

		RequestBuilder mockRequest = post("/albums/update/1").contentType(MediaType.APPLICATION_JSON)
				.content(updatedAlbumAsJSON);

		Album updatedAlbumInDb = new Album(1L, "Kill em all", artist, "Red");

		String updatedAlbumInDbAsJSON = this.mapper.writeValueAsString(updatedAlbumInDb);

		ResultMatcher matchStatus = status().isAccepted();

		ResultMatcher matchBody = content().json(updatedAlbumInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testDelete() throws Exception {

		RequestBuilder mockRequest = delete("/albums/delete/1");

		ResultMatcher matchStatus = status().isNoContent();

		this.mock.perform(mockRequest).andExpect(matchStatus);
	}

	@Test
	void testAssignAlbumToArtist() throws Exception {
		Artist artist = new Artist(1L, "Kirk Hammett", new ArrayList<>());
		
		List<Track> tracks = new ArrayList<>();
		
		Album album = new Album(1L, "Black album", tracks, artist, "Snake");

		String AlbumAsJSON = this.mapper.writeValueAsString(album);

		RequestBuilder mockRequest = put("/albums/1/artists/1");

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(AlbumAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}
}

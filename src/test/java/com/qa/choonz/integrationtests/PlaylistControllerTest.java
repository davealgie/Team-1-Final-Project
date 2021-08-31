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
import com.qa.choonz.persistence.domain.Genre;
import com.qa.choonz.persistence.domain.Playlist;
import com.qa.choonz.persistence.domain.Track;
import com.qa.choonz.persistence.domain.Users;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:test-schema.sql",
		"classpath:test-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")

public class PlaylistControllerTest {
	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {

		Users user = new Users(1L, "Dave", "dave", "davidalgie");

		Playlist playlist = new Playlist(1L, "Chill vibes", "relaxing playlist", "cup of tea", new ArrayList<>(), user);

		String PlaylistAsJSON = this.mapper.writeValueAsString(playlist);

		RequestBuilder mockRequest = post("/playlists/create").contentType(MediaType.APPLICATION_JSON)
				.content(PlaylistAsJSON);

		Playlist savedPlaylist = new Playlist(1L, "Chill vibes", "relaxing playlist", "cup of tea", new ArrayList<>(),
				user);

		String savedPlaylistAsJSON = this.mapper.writeValueAsString(savedPlaylist);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(savedPlaylistAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);

	}

	@Test
	void testReadOne() throws Exception {
		RequestBuilder mockRequest = get("/playlists/read/1");

		Users user = new Users(1L, "Dave", "dave", "davidalgie");

		Playlist playlist = new Playlist(1L, "Chill vibes", "relaxing playlist", "cup of tea", new ArrayList<>(), user);

		String albumAsJSON = this.mapper.writeValueAsString(playlist);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(albumAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);

	}

	@Test
	void testReadAll() throws Exception {
		RequestBuilder mockRequest = get("/playlists/read");

		Users user = new Users(1L, "Dave", "dave", "davidalgie");

		Playlist playlist = new Playlist(1L, "Chill vibes", "relaxing playlist", "cup of tea", new ArrayList<>(), user);

		List<Playlist> playlistInDb = new ArrayList<>();

		playlistInDb.add(playlist);

		String playlistInDbAsJSON = this.mapper.writeValueAsString(playlistInDb);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(playlistInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testUpdate() throws Exception {
		Users user = new Users(1L, "Dave", "dave", "davidalgie");

		Playlist newPlaylist = new Playlist(1L, "Daves playlist", "for dave only", "dave in a cup", new ArrayList<>(),
				user);

		String updatedAlbumAsJSON = this.mapper.writeValueAsString(newPlaylist);

		RequestBuilder mockRequest = post("/playlists/update/1").contentType(MediaType.APPLICATION_JSON)
				.content(updatedAlbumAsJSON);

		Playlist updatedPlaylistInDb = new Playlist(1L, "Daves playlist", "for dave only", "dave in a cup",
				new ArrayList<>(), user);

		String updatedPlaylistInDbAsJSON = this.mapper.writeValueAsString(updatedPlaylistInDb);

		ResultMatcher matchStatus = status().isAccepted();

		ResultMatcher matchBody = content().json(updatedPlaylistInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testDelete() throws Exception {

		RequestBuilder mockRequest = delete("/playlists/delete/1");

		ResultMatcher matchStatus = status().isNoContent();

		this.mock.perform(mockRequest).andExpect(matchStatus);
	}

	@Test
	void testPutTrackToPlaylist() throws Exception {

		Artist artist = new Artist(1L, "Kirk Hammett", new ArrayList<>());

		List<Track> tracks = new ArrayList<Track>();

		Genre genre = new Genre(1L, "Rock", "lead guitar");

		Album album = new Album(1L, "Black album", tracks, artist, "Snake");

		Users user = new Users(1L, "Dave", "dave", "davidalgie", new ArrayList<>());

		Playlist playlist = new Playlist(1L, "Chill vibes", "relaxing playlist", "cup of tea", tracks, user);

		List<Playlist> playlists = new ArrayList<>();

		playlists.add(playlist);

		Track track = new Track(1L, "Nothing else matters", album, playlists, 280, "and nothing else matters", genre);

		tracks.add(track);

		album.setTracks(tracks);

		String updatedPlaylistAsJSON = this.mapper.writeValueAsString(playlist);

		RequestBuilder mockRequest = put("/playlists/1/tracks/1");

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(updatedPlaylistAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testPutUserToPlaylist() throws Exception {
		Artist artist = new Artist(1L, "Kirk Hammett", new ArrayList<>());

		List<Track> tracks = new ArrayList<>();

		Album album = new Album(1L, "Zebra", tracks, artist, "image");

		Users user = new Users(1L, "Dave", "dave", "davidalgie", new ArrayList<>());

		Playlist playlist = new Playlist(1L, "Chill vibes", "relaxing playlist", "cup of tea", new ArrayList<>(), user);

		List<Playlist> playlists = new ArrayList<>();

		playlists.add(playlist);

		Track track = new Track(1L, "Nothing", album, playlists, 100, "else");

		tracks.add(track);

		String updatedPlaylistAsJSON = this.mapper.writeValueAsString(playlist);

		RequestBuilder mockRequest = put("/playlists/1/users/1");

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(updatedPlaylistAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

}

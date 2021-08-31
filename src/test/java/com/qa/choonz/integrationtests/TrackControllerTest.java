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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Artist;

import com.qa.choonz.persistence.domain.Playlist;
import com.qa.choonz.persistence.domain.Track;
import com.qa.choonz.persistence.domain.Users;

public class TrackControllerTest {
	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreateTrack() throws Exception {

		Artist artist = new Artist(1L, "KIrk Hammett", new ArrayList<>());
		List<Track> tracks = new ArrayList<>();
		Album album = new Album(1L, "Zebra", tracks, artist, "image");
		Users user = new Users(1L, "Dave", "davealg", "davidalgie", new ArrayList<>());
		Playlist playlist = new Playlist(1L, "Rock playlist", "Rock description", "Rock Artwork", new ArrayList<>(),
				user);
		List<Playlist> playlists = new ArrayList<>();
		playlists.add(playlist);
		Track track = new Track(1L, "Nothing", album, playlists, 100, "else");

		String trackAsJSON = this.mapper.writeValueAsString(track);

		RequestBuilder mockRequest = post("/tracks/create/album/1").contentType(MediaType.APPLICATION_JSON)
				.content(trackAsJSON);

		Track trackInDb = new Track(1L, "Nothing", album, playlists, 100, "else");

		String trackInDbAsJSON = this.mapper.writeValueAsString(trackInDb);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(trackInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testReadAllTracks() throws Exception {
		RequestBuilder mockRequest = get("/tracks/read");

		Artist artist = new Artist(1L, "KIrk Hammett", new ArrayList<>());
		List<Track> tracks = new ArrayList<>();
		Album album = new Album(1L, "Zebra", tracks, artist, "image");
		Users user = new Users(1L, "Dave", "davealg", "davidalgie", new ArrayList<>());
		Playlist playlist = new Playlist(1L, "Rock playlist", "Rock description", "Rock Artwork", new ArrayList<>(),
				user);
		List<Playlist> playlists = new ArrayList<>();
		playlists.add(playlist);
		Track track = new Track(1L, "Nothing", album, playlists, 100, "else");

		List<Track> tracksInDb = new ArrayList<>();
		tracksInDb.add(track);

		String tracksInDbAsJSON = this.mapper.writeValueAsString(tracksInDb);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(tracksInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testReadOneTrack() throws Exception {

		RequestBuilder mockRequest = get("/tracks/read/1");

		Artist artist = new Artist(1L, "KIrk Hammett", new ArrayList<>());
		List<Track> tracks = new ArrayList<>();
		Album album = new Album(1L, "Zebra", tracks, artist, "image");
		Users user = new Users(1L, "Dave", "davealg", "davidalgie", new ArrayList<>());
		Playlist playlist = new Playlist(1L, "Rock playlist", "Rock description", "Rock Artwork", new ArrayList<>(),
				user);
		List<Playlist> playlists = new ArrayList<>();
		playlists.add(playlist);
		Track track = new Track(1L, "Nothing", album, playlists, 100, "else");

		String trackAsJSON = this.mapper.writeValueAsString(track);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(trackAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);

	}

	@Test
	void testUpdateTrack() throws Exception {

		Artist artist = new Artist(1L, "KIrk Hammett", new ArrayList<>());
		List<Track> tracks = new ArrayList<>();
		Album album = new Album(1L, "Zebra", tracks, artist, "image");
		Users user = new Users(1L, "Dave", "davealg", "davidalgie", new ArrayList<>());
		Playlist playlist = new Playlist(1L, "Rock playlist", "Rock description", "Rock Artwork", new ArrayList<>(),
				user);
		List<Playlist> playlists = new ArrayList<>();
		playlists.add(playlist);
		Track updateTrack = new Track(1L, "Nothing else", album, playlists, 120, "matters");

		String updateTrackAsJSON = this.mapper.writeValueAsString(updateTrack);

		RequestBuilder mockRequest = put("/tracks/update/1/album/1").contentType(MediaType.APPLICATION_JSON)
				.content(updateTrackAsJSON);

		Track updateTrackInDb = new Track(1L, "Nothing else", album, playlists, 120, "matters");

		String updateTrackInDbAsJSON = this.mapper.writeValueAsString(updateTrackInDb);

		ResultMatcher matchStatus = status().isAccepted();

		ResultMatcher matchBody = content().json(updateTrackInDbAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testDeleteTrack() throws Exception {

		RequestBuilder mockRequest = delete("/tracks/delete/1");

		ResultMatcher matchStatus = status().isNoContent();

		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
}

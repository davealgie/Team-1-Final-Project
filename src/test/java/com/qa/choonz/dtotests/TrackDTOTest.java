package com.qa.choonz.dtotests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.domain.Genre;
import com.qa.choonz.rest.dto.TrackDTO;

public class TrackDTOTest {
	private Genre genre = new Genre(0L, "name", "description", new ArrayList<>());
	private Artist artist = new Artist(0L, "artist name", new ArrayList<>());

	private Album album = new Album(0L, "name", new ArrayList<>(), artist, "cover");
	private TrackDTO trackDTO = new TrackDTO(0L, "name", album, new ArrayList<>(), genre, 120, "lyrics");

	@Test
	public void TrackTest() {
		assertThat("TrackDTO [id=0, name=name, genre="+genre.toString()+", album=" + album.toString()
				+ ", playlist=[], duration=120, lyrics=lyrics]").isEqualTo(trackDTO.toString());

	}

}

package com.qa.choonz.dtotests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.domain.Genre;
import com.qa.choonz.rest.dto.AlbumDTO;

public class AlbumDTOTest {
	
	private Artist artist = new Artist(0L, "name", new ArrayList<>());
	private Genre genre = new Genre(0L, "name", "description", new ArrayList<>());
	private AlbumDTO albumDTO = new AlbumDTO(0L, "name",  new ArrayList<>(), artist, genre, "cover");
	
	@Test
	public void AlbumTest() {
		assertThat("AlbumDTO [id=0, name=name, tracks=[], artist="+artist.toString()+", genre="+genre.toString()+", cover=cover]").isEqualTo(albumDTO.toString());
		
	}
	
}


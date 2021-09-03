package com.qa.choonz.unittests;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.repository.ArtistRepository;
import com.qa.choonz.rest.dto.ArtistDTO;
import com.qa.choonz.service.ArtistService;

@SpringBootTest
public class ArtistServiceTest {
	@Autowired
	private ArtistService service;

	@MockBean
	private ArtistRepository repo;

	private Artist artist = new Artist(1L, "Kirk Hammett", new ArrayList<>());
	
	private ArtistDTO artistDTO = new ArtistDTO(1L, "Kirk Hammett", new ArrayList<>());
	
	private Optional<Artist> optionalArtist = Optional.of(new Artist(1L, "Kirk Hammett", new ArrayList<>()));
	
	private Artist updateArtist = new Artist(1L, "new artist name", new ArrayList<>());
	
	private ArtistDTO updateArtistDTO = new ArtistDTO(1L, "new artist name", new ArrayList<>());
	@Test
	public void testCreate() {

		Mockito.when(this.repo.save(artist)).thenReturn(artist);

		assertThat(artistDTO).isEqualTo(this.service.create(artist));

		Mockito.verify(this.repo, Mockito.times(1)).save(artist);
	}
	@Test
	public void testReadAll() {
		
		Mockito.when(this.repo.findAll()).thenReturn(new ArrayList<>());
		
		assertThat(new ArrayList<>()).isEqualTo(this.service.read());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void testReadById() {
		Mockito.when(this.repo.findById(0L)).thenReturn(optionalArtist);
		
		assertThat(artistDTO).isEqualTo(this.service.read(0L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(0L);
	}
	@Test
	public void testUpdate() {
		Mockito.when(this.repo.findById(1L)).thenReturn(optionalArtist);
		
		Mockito.when(this.repo.save(updateArtist)).thenReturn(updateArtist);
		
		assertThat(updateArtistDTO).isEqualTo(this.service.update(updateArtist, 1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(updateArtist);
	}
	@Test
	public void testDelete() {
		assertThat(true).isEqualTo(this.service.delete(0L));
	}
}

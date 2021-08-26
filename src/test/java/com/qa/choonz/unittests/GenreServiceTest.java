package com.qa.choonz.unittests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.choonz.persistence.domain.Genre;
import com.qa.choonz.persistence.repository.GenreRepository;
import com.qa.choonz.rest.dto.GenreDTO;
import com.qa.choonz.service.GenreService;

@SpringBootTest
public class GenreServiceTest {

	@MockBean
	private GenreRepository repo;

	@Autowired
	private GenreService service;

	private Genre genre = new Genre(1L, "name", "description", new ArrayList<>());

	private GenreDTO genreDTO = new GenreDTO(1L, "name", "description", new ArrayList<>());

	private Optional<Genre> optionalGenre = Optional.of(new Genre(1L, "name", "description", new ArrayList<>()));

	private Genre updatedGenre = new Genre(1L, "updated name", "updated description", new ArrayList<>());

	private GenreDTO updatedGenreDTO = new GenreDTO(1L, "updated name", "updated description", new ArrayList<>());

	@Test
	public void testCreate() {

		Mockito.when(this.repo.save(genre)).thenReturn(genre);

		assertThat(genreDTO).isEqualTo(this.service.create(genre));

		Mockito.verify(this.repo, Mockito.times(1)).save(genre);
	}

	@Test
	public void testReadAll() {

		Mockito.when(this.repo.findAll()).thenReturn(new ArrayList<>());

		assertThat(new ArrayList<>()).isEqualTo(this.service.read());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void testReadById() {
		Mockito.when(this.repo.findById(1L)).thenReturn(optionalGenre);

		assertThat(genreDTO).isEqualTo(this.service.read(1L));

		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}

	@Test
	public void testUpdate() {
		Mockito.when(this.repo.findById(1L)).thenReturn(optionalGenre);

		Mockito.when(this.repo.save(updatedGenre)).thenReturn(updatedGenre);

		assertThat(updatedGenreDTO).isEqualTo(this.service.update(updatedGenre, 1L));

		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);

		Mockito.verify(this.repo, Mockito.times(1)).save(updatedGenre);
	}

	@Test
	public void testeDelete() {
		assertThat(true).isEqualTo(this.service.delete(1L));
	}

}

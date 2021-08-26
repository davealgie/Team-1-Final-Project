package com.qa.choonz.unittests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.choonz.persistence.domain.Playlist;
import com.qa.choonz.persistence.domain.Users;
import com.qa.choonz.persistence.repository.PlaylistRepository;
import com.qa.choonz.persistence.repository.UserRepository;
import com.qa.choonz.rest.dto.PlaylistDTO;
import com.qa.choonz.service.PlaylistService;

@SpringBootTest
public class PlaylistServiceTest {
	
	@MockBean
	private PlaylistRepository repo;
	
	@MockBean
	private UserRepository userRepo;
	
	@Autowired
	private PlaylistService service;
	
	
	private Optional<Users> optionalUser = Optional.of(new Users(1L, "fullname", "username", "password"));
	
	private Playlist playlist = new Playlist(1L, "name", "description", "artwork", new ArrayList<>());
	
	private PlaylistDTO playlistDTO = new PlaylistDTO(1L, "name", "description", "artwork", new ArrayList<>());
	
	private Optional<Playlist> optionalPlaylist = Optional.of(new Playlist(1L, "name", "description", "artwork", new ArrayList<>()));
	
	private Playlist updatedPlaylist = new Playlist(1L, "updated name", "description", "artwork", new ArrayList<>());
	
	private PlaylistDTO updatedPlaylistDTO = new PlaylistDTO(1L, "updated name", "description", "artwork", new ArrayList<>());
	
	@Test
	public void testCreate() {
		
		Mockito.when(this.userRepo.findById(1L)).thenReturn(optionalUser);
		
		Mockito.when(this.repo.save(playlist)).thenReturn(playlist);
		
		assertThat(playlistDTO).isEqualTo(this.service.create(playlist));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(playlist);
	}
	
	@Test
	public void testReadAll() {
		
		Mockito.when(this.repo.findAll()).thenReturn(new ArrayList<>());
		
		assertThat(new ArrayList<>()).isEqualTo(this.service.read());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void testReadById() {
		Mockito.when(this.repo.findById(1L)).thenReturn(optionalPlaylist);
		
		assertThat(playlistDTO).isEqualTo(this.service.read(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}
	
	@Test
	public void testUpdate() {
		Mockito.when(this.repo.findById(1L)).thenReturn(optionalPlaylist);
		
		Mockito.when(this.repo.save(updatedPlaylist)).thenReturn(updatedPlaylist);
		
		assertThat(updatedPlaylistDTO).isEqualTo(this.service.update(updatedPlaylist, 1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedPlaylist);
	}
	
	@Test
	public void testDelete() {
		assertThat(true).isEqualTo(this.service.delete(1L));
	}

}
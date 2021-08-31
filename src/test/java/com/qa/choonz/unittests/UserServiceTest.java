package com.qa.choonz.unittests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.choonz.persistence.domain.Users;
import com.qa.choonz.persistence.repository.UserRepository;
import com.qa.choonz.rest.dto.UserDTO;
import com.qa.choonz.service.UserService;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
	@MockBean
	private UserRepository repo;

	@Autowired
	private UserService service;

	@MockBean
	private Users users;

	@MockBean
	private UserDTO usersDTO;

	private Users user = new Users(1L, "fullname", "username", "password", new ArrayList<>());
	
	private UserDTO userDTO = new UserDTO(1L, "fullname", "username", "password", new ArrayList<>());
	
	private Optional<Users> optionalUser = Optional.of(new Users(1L, "fullname", "username", "password", new ArrayList<>()));
	
	private Users newUser = new Users(1L, "fullnames", "usernames", "passwords", new ArrayList<>());
	
	private UserDTO newUserDTO = new UserDTO(1L, "fullnames", "usernames","passwords", new ArrayList<>());
	@Test
	void testCreate() {

		Mockito.when(this.repo.save(user)).thenReturn(user);

		assertThat(userDTO).isEqualTo(this.service.create(user));

		Mockito.verify(this.repo, Mockito.times(1)).save(user);
	}

	@Test
	void testReadAll() {

		Mockito.when(this.repo.findAll()).thenReturn(new ArrayList<>());

		assertThat(new ArrayList<>()).isEqualTo(this.service.readAllUsers());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}

	@Test
	void testReadById() {
		Mockito.when(this.repo.findById(1L)).thenReturn(optionalUser);

		assertThat(userDTO).isEqualTo(this.service.read(1L));

		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}

	@Test
	void testUpdate() {
		Mockito.when(this.repo.findById(1L)).thenReturn(optionalUser);
		
		Mockito.when(this.repo.save(newUser)).thenReturn(newUser);
		
		assertThat(newUserDTO).isEqualTo(this.service.update(newUser, 1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(newUser);
	}

	@Test
	void testDelete() {

		assertThat(true).isEqualTo(this.service.delete(1L));
	}

}

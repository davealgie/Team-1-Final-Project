package com.qa.choonz.service;

import java.util.List;

import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.choonz.persistence.domain.Users;
import com.qa.choonz.persistence.repository.UserRepository;
import com.qa.choonz.rest.dto.UserDTO;
import com.qa.choonz.exception.UsersNotFoundException;

@Service
public class UserService {

	public UserRepository repo;

	private ModelMapper mapper;

	public UserService(UserRepository repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	private UserDTO mapToDTO(Users users) {
		return this.mapper.map(users, UserDTO.class);
	}

	// create
	public UserDTO create(Users user) {
		Users created = this.repo.save(user);
		UserDTO mapped = this.mapToDTO(created);
		return mapped;
	}

	// read all
	public List<UserDTO> readAllUsers() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// read by id
	public UserDTO read(Long userId) {
		return this.mapToDTO(this.repo.findById(userId).orElseThrow(UsersNotFoundException::new));

	}

	// update
	public UserDTO update(Users user, long id) {
		Users toUpdate = this.repo.findById(id).orElseThrow(UsersNotFoundException::new);
		toUpdate.setFull_name(user.getFull_name());
		toUpdate.setUser_name(user.getUser_name());
		toUpdate.setPassword(user.getPassword());
		toUpdate.setPlaylist(user.getPlaylist());
		Users updated = this.repo.save(toUpdate);
		return this.mapToDTO(updated);
	}

	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}

	public UserDTO readByUsername(String username) {
		return this.mapToDTO(this.repo.findByUsername(username));
		
	}

}

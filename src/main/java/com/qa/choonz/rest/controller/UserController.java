package com.qa.choonz.rest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.choonz.persistence.domain.Users;

import com.qa.choonz.rest.dto.UserDTO;
import com.qa.choonz.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://127.0.0.1:5500")
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}

	// create
	@PostMapping("/create")
	public ResponseEntity<UserDTO> create(@Valid @RequestBody Users user) {
		return new ResponseEntity<UserDTO>(this.service.create(user), HttpStatus.CREATED);
	}

	// read all
	@GetMapping("/read")
	public ResponseEntity<List<UserDTO>> read() {
		return new ResponseEntity<List<UserDTO>>(this.service.readAllUsers(), HttpStatus.OK);

	}

	// read by id
	@GetMapping("/read/{user_id}")
	public ResponseEntity<UserDTO> read(@PathVariable Long user_id) {
		return new ResponseEntity<UserDTO>(this.service.read(user_id), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/read-name/{username}")
	public ResponseEntity<UserDTO> readByUsername(@PathVariable String username) {
		return new ResponseEntity<UserDTO>(this.service.readByUsername(username), HttpStatus.ACCEPTED);
	}


	//
	@PostMapping("/update/{user_id}")
	public ResponseEntity<UserDTO> update(@RequestBody Users user, @PathVariable Long user_id) {
		return new ResponseEntity<UserDTO>(this.service.update(user, user_id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{user_id}")
	public ResponseEntity<UserDTO> delete(@PathVariable Long user_id) {
		return this.service.delete(user_id) ? new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<UserDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

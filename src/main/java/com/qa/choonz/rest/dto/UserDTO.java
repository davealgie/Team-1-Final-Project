package com.qa.choonz.rest.dto;

import java.util.List;
import java.util.Objects;



import com.qa.choonz.persistence.domain.Playlist;


public class UserDTO {

	private long id;
	private String name;
	private String username;
	private String password;
	private List<Playlist> playlist;

	public UserDTO() {
		super();
	}

	public UserDTO(long id, String name, String username, String password, List<Playlist> playlist) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.playlist = playlist;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Playlist> getPlayList() {
		return playlist;
	}

	public void setPlayList(List<Playlist> playList) {
		this.playlist = playList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, password, playlist, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(playlist, other.playlist) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", playlist=" + playlist + "]";
	}
	
}

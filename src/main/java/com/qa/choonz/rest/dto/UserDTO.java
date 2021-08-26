package com.qa.choonz.rest.dto;

import java.util.List;
import java.util.Objects;



import com.qa.choonz.persistence.domain.Playlist;


public class UserDTO {

	private long id;
	private String full_name;
	private String user_name;
	private String password;
	private List<Playlist> playlist;

	public UserDTO() {
		super();
	}

	public UserDTO(long id, String full_name, String user_name, String password, List<Playlist> playlist) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.user_name = user_name;
		this.password = password;
		this.playlist = playlist;
	}
	public UserDTO(long id, String full_name, String user_name, List<Playlist> playlist) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.user_name = user_name;
		this.playlist = playlist;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}

	@Override
	public int hashCode() {
		return Objects.hash(full_name, id, password, playlist, user_name);
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
		return Objects.equals(full_name, other.full_name) && id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(playlist, other.playlist) && Objects.equals(user_name, other.user_name);
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", full_name=" + full_name + ", user_name=" + user_name + ", password=" + password
				+ ", playlist=" + playlist + "]";
	}

}


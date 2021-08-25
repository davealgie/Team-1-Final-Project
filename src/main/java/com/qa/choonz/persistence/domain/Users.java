package com.qa.choonz.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;



import com.sun.istack.NotNull;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 100)
	private String full_name;

	@NotNull
	@Size(max = 100)
	@Column(unique = true)
	private String user_name;

	@NotNull
	private String password;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Playlist> playlist = new ArrayList<>();

	public Users() {
		super();
	}

	public Users(long id, @NotNull @Size(max = 100) String full_name, @NotNull @Size(max = 100) String user_name, @NotNull String password, List<Playlist> playlist) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.user_name = user_name;
		this.password = password;
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
		Users other = (Users) obj;
		return Objects.equals(full_name, other.full_name) && id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(playlist, other.playlist) && Objects.equals(user_name, other.user_name);
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", full_name=" + full_name + ", user_name=" + user_name + ", password=" + password
				+ ", playlist=" + playlist + "]";
	}
	
}


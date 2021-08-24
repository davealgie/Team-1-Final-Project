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
	private String name;

	@NotNull
	@Size(max = 100)
	@Column(unique = true)
	private String username;

	@NotNull
	private String password;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Playlist> playlist = new ArrayList<>();

	public Users() {
		super();
	}

	public Users(long id, @NotNull @Size(max = 100) String name, @NotNull @Size(max = 100) String username, @NotNull String password, List<Playlist> playlist) {
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
		Users other = (Users) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(playlist, other.playlist) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", playList=" + playlist + "]";
	}
	
}
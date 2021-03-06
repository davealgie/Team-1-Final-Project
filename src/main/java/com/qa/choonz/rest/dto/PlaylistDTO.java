package com.qa.choonz.rest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.qa.choonz.persistence.domain.Track;
import com.qa.choonz.persistence.domain.Users;

public class PlaylistDTO {

    private long id;
    private String name;
    private String description;
    private String artwork;
    private List<Track> tracks = new ArrayList<>();
    private Users users;

    public PlaylistDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public PlaylistDTO(long id, String name, String description, String artwork, List<Track> tracks, Users users) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.artwork = artwork;
        this.tracks = tracks;
        this.users = users;
    }
    
    public PlaylistDTO(String name, String description, String artwork, List<Track> tracks) {
 		super();
 		this.name = name;
 		this.description = description;
 		this.artwork = artwork;
 		this.tracks = tracks;
 	}
    
	public PlaylistDTO(Long id, String name, String description, String artwork) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.artwork = artwork;
	}
	
	public PlaylistDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the artwork
     */
    public String getArtwork() {
        return artwork;
    }

    /**
     * @param artwork the artwork to set
     */
    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    /**
     * @return the tracks
     */
    public List<Track> getTracks() {
        return tracks;
    }

    /**
     * @param tracks the tracks to set
     */
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

	@Override
	public String toString() {
		return "PlaylistDTO [id=" + id + ", name=" + name + ", description=" + description + ", artwork=" + artwork
				+ ", tracks=" + tracks + ", users=" + users + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(artwork, description, id, name, tracks, users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlaylistDTO other = (PlaylistDTO) obj;
		return Objects.equals(artwork, other.artwork) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(name, other.name) && Objects.equals(tracks, other.tracks)
				&& Objects.equals(users, other.users);
	}



}

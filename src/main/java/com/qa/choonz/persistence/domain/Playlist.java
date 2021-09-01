package com.qa.choonz.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(max = 500)
    @Column(unique = true)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "users_user_id", referencedColumnName = "user_id")
    private Users users;

    @NotNull
    @Size(max = 1000)
    @Column(unique = true)
    private String artwork;

//    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
//    private List<Track> tracks;
    
    @ManyToMany
    @JoinTable(name = "playlists_tracks", 
    joinColumns = @JoinColumn(name = "playlist_id"), 
    inverseJoinColumns = @JoinColumn(name = "track_id"))
    private List<Track> tracks = new ArrayList<>();

    public Playlist() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Playlist(long id, @NotNull @Size(max = 100) String name, @NotNull @Size(max = 500) String description,
            @NotNull @Size(max = 1000) String artwork, List<Track> tracks, Users users) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.artwork = artwork;
        this.tracks = tracks;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Playlist [id=").append(id).append(", name=").append(name).append(", description=")
                .append(description).append(", artwork=").append(artwork).append(", tracks=").append(tracks)
                .append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(artwork, description, id, name, tracks);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Playlist)) {
            return false;
        }
        Playlist other = (Playlist) obj;
        return Objects.equals(artwork, other.artwork) && Objects.equals(description, other.description)
                && id == other.id && Objects.equals(name, other.name) && Objects.equals(tracks, other.tracks);
    }

	public void addTracks(Track track) {
		tracks.add(track);
		
	}

}

package com.qa.choonz.persistence.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "tracks")
    private List<Playlist> playlist;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    // in seconds
    private int duration;

    private String lyrics;

    public Track() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Track(long id, @NotNull @Size(max = 100) String name, Album album, List<Playlist> playlist, int duration,
            String lyrics, Genre genre) {
        super();
        this.id = id;
        this.name = name;
        this.album = album;
        this.playlist = playlist;
        this.duration = duration;
        this.genre = genre;
        this.lyrics = lyrics;
    }
    public Track(long id, @NotNull @Size(max = 100) String name, Album album, List<Playlist> playlist, int duration,
            String lyrics) {
        super();
        this.id = id;
        this.name = name;
        this.album = album;
        this.playlist = playlist;
        this.duration = duration;
        this.lyrics = lyrics;
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Playlist> playlist) {
        this.playlist = playlist;
    }

    public int getDuration() {
        return duration;
    }

    public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Track [id=").append(id).append(", name=").append(name).append(", album=").append(album)
                .append(", playlist=").append(playlist).append(", genre=").append(genre).append(", duration=").append(duration).append(", lyrics=")
                .append(lyrics).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(album, duration, id, lyrics, name, playlist, genre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        Track other = (Track) obj;
        return Objects.equals(album, other.album) && duration == other.duration && id == other.id
                && Objects.equals(lyrics, other.lyrics) && Objects.equals(name, other.name) && Objects.equals(genre, other.genre)
                && Objects.equals(playlist, other.playlist);
    }

}

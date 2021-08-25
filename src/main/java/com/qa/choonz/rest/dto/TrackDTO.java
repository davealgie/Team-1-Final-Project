package com.qa.choonz.rest.dto;

import java.util.List;
import java.util.Objects;

import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Playlist;

public class TrackDTO {

    private long id;
    private String name;
    private Album album;
    private List<Playlist> playlist;
    private int duration;
    private String lyrics;

    public TrackDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

	public TrackDTO(long id, String name, Album album, List<Playlist> playlist, int duration, String lyrics) {
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

	public List<Playlist>getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}

	public int getDuration() {
		return duration;
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
	public int hashCode() {
		return Objects.hash(album, duration, id, lyrics, name, playlist);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrackDTO other = (TrackDTO) obj;
		return Objects.equals(album, other.album) && duration == other.duration && id == other.id
				&& Objects.equals(lyrics, other.lyrics) && Objects.equals(name, other.name)
				&& Objects.equals(playlist, other.playlist);
	}

	@Override
	public String toString() {
		return "TrackDTO [id=" + id + ", name=" + name + ", album=" + album + ", playlist=" + playlist + ", duration="
				+ duration + ", lyrics=" + lyrics + "]";
	}

}

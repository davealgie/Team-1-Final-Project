package com.qa.choonz.rest.dto;

import java.util.List;
import java.util.Objects;

import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.domain.Genre;
import com.qa.choonz.persistence.domain.Track;

public class AlbumDTO {

    private long id;
    private String name;
    private List<Track> tracks;
    private Artist artist;
    private String cover;

    public AlbumDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AlbumDTO(long id, String name, List<Track> tracks, Artist artist,  String cover) {
        super();
        this.id = id;
        this.name = name;
        this.tracks = tracks;
        this.artist = artist;
        this.cover = cover;
        
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

	public List<Track> getTracks() {
		return tracks;
	}

<<<<<<< HEAD
=======
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public Artist getArtist() {
		return artist;
	}
>>>>>>> 505b63c784d534af12f35ec3feccce9626ad4c4f

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getCover() {
		return cover;
	}

<<<<<<< HEAD
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AlbumDTO [id=").append(id).append(", name=").append(name).append(", tracks=").append(tracks)
                .append(", artist=").append(artist).append(", cover=").append(cover)
                .append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, cover, id, name, tracks);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlbumDTO)) {
            return false;
        }
        AlbumDTO other = (AlbumDTO) obj;
        return Objects.equals(artist, other.artist) && Objects.equals(cover, other.cover)
                && id == other.id && Objects.equals(name, other.name)
                && Objects.equals(tracks, other.tracks);
    }
=======
	public void setCover(String cover) {
		this.cover = cover;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artist, cover, id, name, tracks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlbumDTO other = (AlbumDTO) obj;
		return Objects.equals(artist, other.artist) && Objects.equals(cover, other.cover) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(tracks, other.tracks);
	}
>>>>>>> 505b63c784d534af12f35ec3feccce9626ad4c4f

	@Override
	public String toString() {
		return "AlbumDTO [id=" + id + ", name=" + name + ", tracks=" + tracks + ", artist=" + artist + ", cover="
				+ cover + "]";
	}
    
}
   
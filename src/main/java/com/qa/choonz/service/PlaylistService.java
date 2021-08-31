package com.qa.choonz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.choonz.exception.PlaylistNotFoundException;
import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.domain.Playlist;
import com.qa.choonz.persistence.domain.Track;
import com.qa.choonz.persistence.domain.Users;
import com.qa.choonz.persistence.repository.PlaylistRepository;
import com.qa.choonz.persistence.repository.TrackRepository;
import com.qa.choonz.persistence.repository.UserRepository;
import com.qa.choonz.rest.dto.PlaylistDTO;

@Service
public class PlaylistService {

    private PlaylistRepository repo;
    private UserRepository repoUser;
    private TrackRepository repoTrack;
    private ModelMapper mapper;

    public PlaylistService(PlaylistRepository repo, TrackRepository repoTrack, UserRepository repoUser, ModelMapper mapper) {
        super();
        this.repoTrack = repoTrack;
        this.repo = repo;
        this.repoUser = repoUser;
        this.mapper = mapper;
    }

    private PlaylistDTO mapToDTO(Playlist playlist) {
        return this.mapper.map(playlist, PlaylistDTO.class);
    }

    public PlaylistDTO create(Playlist playlist) {
        Playlist created = this.repo.save(playlist);
        return this.mapToDTO(created);
    }

    public List<PlaylistDTO> read() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public PlaylistDTO read(long id) {
        Playlist found = this.repo.findById(id).orElseThrow(PlaylistNotFoundException::new);
        return this.mapToDTO(found);
    }

    public PlaylistDTO update(Playlist playlist, long id) {
        Playlist toUpdate = this.repo.findById(id).orElseThrow(PlaylistNotFoundException::new);
        toUpdate.setName(playlist.getName());
        toUpdate.setDescription(playlist.getDescription());
        toUpdate.setArtwork(playlist.getArtwork());
        toUpdate.setTracks(playlist.getTracks());
        Playlist updated = this.repo.save(toUpdate);
        return this.mapToDTO(updated);
    }
    
	public PlaylistDTO assignTrackToPlaylist(Long playlistId, Long trackId) {
		Playlist playlist = repo.findById(playlistId).get();
		Track track = repoTrack.findById(trackId).get();
		playlist.addTracks(track);
		Playlist updated = this.repo.save(playlist);
		return this.mapToDTO(updated);
	}

    public boolean delete(long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }

	public PlaylistDTO assignUser(Long playlistId, Long userId) {
		Playlist playlist = repo.findById(playlistId).get();
		Users user = repoUser.findById(userId).get();
		playlist.setUsers(user);
		Playlist updated = this.repo.save(playlist);
		return this.mapToDTO(updated);
	}


}

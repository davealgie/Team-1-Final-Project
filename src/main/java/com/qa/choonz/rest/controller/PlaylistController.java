package com.qa.choonz.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.choonz.persistence.domain.Playlist;
import com.qa.choonz.rest.dto.PlaylistDTO;
import com.qa.choonz.service.PlaylistService;

@RestController
@RequestMapping("/playlists")
@CrossOrigin("http://127.0.0.1:5500")
public class PlaylistController {

    private PlaylistService service;

    public PlaylistController(PlaylistService service) {
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<PlaylistDTO> create(@RequestBody Playlist playlist) {
        return new ResponseEntity<PlaylistDTO>(this.service.create(playlist), HttpStatus.CREATED);
    }
    
    // user
    @PutMapping("/{playlistId}/users/{userId}")
    public ResponseEntity<PlaylistDTO> assignUserToPlaylist(@PathVariable Long playlistId, @PathVariable Long userId) {
        return new ResponseEntity<PlaylistDTO>(this.service.assignUser(playlistId, userId), HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<List<PlaylistDTO>> read() {
        return new ResponseEntity<List<PlaylistDTO>>(this.service.read(), HttpStatus.OK);
    }
    
    @PutMapping("/{playlistId}/tracks/{trackId}")
    public ResponseEntity<PlaylistDTO> assignTrackToPlaylist(@PathVariable Long playlistId, @PathVariable Long trackId) {
        return new ResponseEntity<PlaylistDTO>(this.service.assignTrackToPlaylist(playlistId, trackId), HttpStatus.CREATED);
    }
    
    @PutMapping("/{playlistId}/track-name/{trackname}")
    public ResponseEntity<PlaylistDTO> assignTrackToPlaylistByName(@PathVariable Long playlistId, @PathVariable String trackname) {
        return new ResponseEntity<PlaylistDTO>(this.service.assignTrackToPlaylistByName(playlistId, trackname), HttpStatus.CREATED);
    }
    
    @PutMapping("/{playlistId}/track-remove/{trackId}")
    public ResponseEntity<PlaylistDTO> removeTrackFromPlaylist(@PathVariable Long playlistId, @PathVariable Long trackId) {
        return new ResponseEntity<PlaylistDTO>(this.service.removeTrackFromPlaylist(playlistId, trackId), HttpStatus.CREATED);
    }
    
    @GetMapping("/read/{id}")
    public ResponseEntity<PlaylistDTO> read(@PathVariable long id) {
        return new ResponseEntity<PlaylistDTO>(this.service.read(id), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<PlaylistDTO> update(@RequestBody Playlist playlist, @PathVariable long id) {
        return new ResponseEntity<PlaylistDTO>(this.service.update(playlist, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PlaylistDTO> delete(@PathVariable long id) {
        return this.service.delete(id) ? new ResponseEntity<PlaylistDTO>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<PlaylistDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

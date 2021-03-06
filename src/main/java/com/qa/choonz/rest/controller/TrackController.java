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

import com.qa.choonz.persistence.domain.Track;
import com.qa.choonz.rest.dto.TrackDTO;
import com.qa.choonz.service.TrackService;

@RestController
@RequestMapping("/tracks")
@CrossOrigin("http://127.0.0.1:5500")
public class TrackController {

    private TrackService service;

    public TrackController(TrackService service) {
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<TrackDTO> create(@RequestBody Track track) {
        return new ResponseEntity<TrackDTO>(this.service.create(track), HttpStatus.CREATED);
    }
    
    // Album
    @PutMapping("/{trackId}/albums/{albumId}")
    public ResponseEntity<TrackDTO> assignTrackToAlbum(@PathVariable Long trackId, @PathVariable Long albumId) {
        return new ResponseEntity<TrackDTO>(this.service.assignAlbum(trackId, albumId), HttpStatus.CREATED);
    }
    
    //Genre
    @PutMapping("/{trackId}/genres/{genreId}")
    public ResponseEntity<TrackDTO> assignTrackToGenre(@PathVariable Long trackId, @PathVariable Long genreId) {
        return new ResponseEntity<TrackDTO>(this.service.assignGenre(trackId, genreId), HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<List<TrackDTO>> read() {
        return new ResponseEntity<List<TrackDTO>>(this.service.read(), HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<TrackDTO> read(@PathVariable long id) {
        return new ResponseEntity<TrackDTO>(this.service.read(id), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<TrackDTO> update(@RequestBody Track track, @PathVariable long id) {
        return new ResponseEntity<TrackDTO>(this.service.update(track, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TrackDTO> delete(@PathVariable long id) {
        return this.service.delete(id) ? new ResponseEntity<TrackDTO>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<TrackDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/read-track/{name}")
    public ResponseEntity<TrackDTO> read(@PathVariable String name) {
        return new ResponseEntity<TrackDTO>(this.service.readByName(name), HttpStatus.OK);
    }

}

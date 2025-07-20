package com.r0dmd.tunetray.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r0dmd.tunetray.exception.TrackNotFoundException;
import com.r0dmd.tunetray.model.Track;
import com.r0dmd.tunetray.repository.TrackRepository;

// Marks this class as a REST controller for handling HTTP requests.
@RestController
@RequestMapping("/api/tracks") // Base URL path for this controller.
public class TrackController {

  // `private final` ensures this dependency is set once via constructor
  // and can't be changed later, promoting immutability and safer code.
  private final TrackRepository trackRepository;

  // Constructor injection of the repository.
  public TrackController(TrackRepository trackRepository) {
    this.trackRepository = trackRepository;
  }

  @GetMapping
  public List<Track> getAllTracks() {
    return trackRepository.findAll();
  }

  @PostMapping
  // ResponseEntity represents the full HTTP response—body, status code, and
  // headers. Gives control over what the server sends back,
  // allowing customization of the HTTP response:
  // - Body: the saved track object (converted to JSON)
  // - Status: 201 Created indicates a resource was successfully created
  public ResponseEntity<Track> createTrack(@RequestBody /* maps JSON req body to a Track object */ Track track) {
    Track savedTrack = trackRepository.save(track);
    return new ResponseEntity<>(savedTrack, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Track> updateTrack(@PathVariable Long id, @RequestBody Track updatedTrack) {
    return trackRepository.findById(id)
        .map(track -> {
          track.setTitle(updatedTrack.getTitle());
          track.setArtist(updatedTrack.getArtist());
          track.setAlbum(updatedTrack.getAlbum());
          return ResponseEntity.ok(trackRepository.save(track));
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTrack(@PathVariable Long id) {
    if (!trackRepository.existsById(id)) {
      // .notFound(): Returns 404 if not found.
      // .build() finalizes the creation of a ResponseEntity without a body. It’s used
      // to return responses like 204 No Content or 404 Not Found quickly and cleanly.
      // return ResponseEntity.notFound().build();

      // BUT we throw a custom exception:
      throw new TrackNotFoundException(id);
    }

    trackRepository.deleteById(id);
    // .noContent(): Returns 204 on success.
    return ResponseEntity.noContent().build();
  }

}
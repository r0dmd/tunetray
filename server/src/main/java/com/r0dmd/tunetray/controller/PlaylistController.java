package com.r0dmd.tunetray.controller;

import com.r0dmd.tunetray.model.Playlist;
import com.r0dmd.tunetray.repository.PlaylistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // Allow Angular app with CORS
// REST Controller for managing Playlists
@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

  private final PlaylistRepository playlistRepository;

  // Constructor injection
  public PlaylistController(PlaylistRepository playlistRepository) {
    this.playlistRepository = playlistRepository;
  }

  @GetMapping
  public List<Playlist> getAllPlaylists() {
    return playlistRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
    Playlist savedPlaylist = playlistRepository.save(playlist);
    return new ResponseEntity<>(savedPlaylist, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Playlist> updatePlaylist(@PathVariable Long id, @RequestBody Playlist updatedPlaylist) {
    return playlistRepository.findById(id)
        .map(playlist -> {
          playlist.setName(updatedPlaylist.getName());
          playlist.setDescription(updatedPlaylist.getDescription());
          playlist.setTracks(updatedPlaylist.getTracks());
          return ResponseEntity.ok(playlistRepository.save(playlist));
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
    if (!playlistRepository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    playlistRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}

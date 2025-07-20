package com.r0dmd.tunetray.model;

import jakarta.persistence.*;
import java.util.List;

// Playlist entity representing the playlist table in the DB
@Entity
public class Playlist {

  // Auto-generated ID for the playlist
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;

  // A playlist contains a list of tracks
  @ManyToMany
  private List<Track> tracks;

  // Default constructor (required by JPA)
  public Playlist() {
  }

  // Constructor without ID (auto-generated)
  public Playlist(String name, String description, List<Track> tracks) {
    this.name = name;
    this.description = description;
    this.tracks = tracks;
  }

  // Getters and setters for fields (required for JPA & JSON serialization)
  public Long getId() {
    return id;
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

  public List<Track> getTracks() {
    return tracks;
  }

  public void setTracks(List<Track> tracks) {
    this.tracks = tracks;
  }
}

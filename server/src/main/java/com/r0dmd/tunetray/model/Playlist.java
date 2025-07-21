package com.r0dmd.tunetray.model;

import jakarta.persistence.*;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.Set;
import java.util.HashSet;

// Playlist entity representing the playlist table in the DB
@Entity
public class Playlist {

  // Auto-generated ID for the playlist
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;

  @ManyToMany
  @JoinTable(name = "playlist_tracks", joinColumns = @JoinColumn(name = "playlist_id"), inverseJoinColumns = @JoinColumn(name = "track_id"))
  private Set<Track> tracks = new HashSet<>();

  // Default constructor (required by JPA)
  public Playlist() {
  }

  // Constructor without ID (auto-generated)
  public Playlist(String name, String description, Set<Track> tracks) {
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

  public Set<Track> getTracks() {
    return tracks;
  }

  public void setTracks(Set<Track> tracks) {
    this.tracks = tracks;
  }
}

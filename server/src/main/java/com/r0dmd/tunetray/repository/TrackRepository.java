package com.r0dmd.tunetray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.r0dmd.tunetray.model.Track;

// Marks this as a Spring-managed repository bean (optional since JpaRepository implementations are automatically picked up, but good for clarity).
@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
  // Provides basic CRUD methods (save, findAll, findById, delete, etc.) for Track
  // entities with Long as the ID type.
  // No need to write any implementation code.

}

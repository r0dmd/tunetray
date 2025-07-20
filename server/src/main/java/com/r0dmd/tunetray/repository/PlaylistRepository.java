package com.r0dmd.tunetray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.r0dmd.tunetray.model.Playlist;

// Repository interface for Playlist CRUD
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}

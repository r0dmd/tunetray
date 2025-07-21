package com.r0dmd.tunetray;

import java.util.HashSet;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.r0dmd.tunetray.model.Playlist;
import com.r0dmd.tunetray.model.Track;
import com.r0dmd.tunetray.repository.PlaylistRepository;
import com.r0dmd.tunetray.repository.TrackRepository;

// Marks this class as a source of Spring Beans (configuration)
@Configuration
public class DataInitializer {

  // Tells Spring to run this method and register its return value.
  @Bean
  // A special Spring interface for running code at startup,
  // so that this method runs once when the application starts.
  CommandLineRunner initDatabase(TrackRepository trackRepository, PlaylistRepository playlistRepository) {
    return args -> {
      // Some example tracks into the database
      Track t1 = trackRepository.save(new Track(
          "So What",
          "Miles Davis",
          "Kind of Blue"));
      Track t2 = trackRepository.save(new Track(
          "Take Five",
          "The Dave Brubeck Quartet",
          "Time Out"));
      Track t3 = trackRepository.save(new Track(
          "My Favorite Things",
          "John Coltrane",
          "My Favorite Things"));
      Track t4 = trackRepository.save(new Track(
          "Round Midnight",
          "Thelonious Monk",
          "'Round Midnight"));
      Track t5 = trackRepository.save(new Track(
          "Cantaloupe Island",
          "Herbie Hancock",
          "Empyrean Isles"));

      Playlist jazzClassics = new Playlist();
      jazzClassics.setName("Jazz Classics");
      jazzClassics.setDescription("My favorite standards");
      jazzClassics.setTracks(new HashSet<>(List.of(t1, t2, t3)));
      playlistRepository.save(jazzClassics);

      Playlist mellowJazz = new Playlist();
      mellowJazz.setName("Mellow Jazz");
      mellowJazz.setDescription("Songs to chill out with");
      mellowJazz.setTracks(new HashSet<>(List.of(t4, t5)));
      playlistRepository.save(mellowJazz);
    };

  }
}
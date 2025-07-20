package com.r0dmd.tunetray;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.r0dmd.tunetray.model.Track;
import com.r0dmd.tunetray.repository.TrackRepository;

// Marks this class as a source of Spring Beans (configuration)
@Configuration
public class DataInitializer {

  // Tells Spring to run this method and register its return value.
  @Bean
  // A special Spring interface for running code at startup,
  // so that this method runs once when the application starts.
  CommandLineRunner initDatabase(TrackRepository trackRepository) {
    return args -> {
      // Some example tracks into the database
      trackRepository.save(new Track(
          "So What",
          "Miles Davis",
          "Kind of Blue"));
      trackRepository.save(new Track(
          "Take Five",
          "The Dave Brubeck Quartet",
          "Time Out"));
      trackRepository.save(new Track(
          "My Favorite Things",
          "John Coltrane",
          "My Favorite Things"));
      trackRepository.save(new Track(
          "Round Midnight",
          "Thelonious Monk",
          "'Round Midnight"));
      trackRepository.save(new Track(
          "Cantaloupe Island",
          "Herbie Hancock",
          "Empyrean Isles"));
    };
  }
}
package com.r0dmd.tunetray.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Allows handling exceptions globally across all controllers.
@ControllerAdvice
public class GlobalExceptionHandler {

  // Maps specific exceptions to custom responses.
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex) {
    return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
    return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");
  }

  @ExceptionHandler(TrackNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleTrackNotFound(TrackNotFoundException ex) {
    return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  // Utility method to build consistent JSON error responses.
  private ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String message) {
    return ResponseEntity.status(status).body(
        Map.of(
            "timestamp", LocalDateTime.now(),
            "status", status.value(),
            "error", status.getReasonPhrase(),
            "message", message));
  }
}
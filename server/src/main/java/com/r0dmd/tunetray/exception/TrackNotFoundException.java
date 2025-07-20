package com.r0dmd.tunetray.exception;

public class TrackNotFoundException extends RuntimeException {

    public TrackNotFoundException(Long id) {
        super("Track with ID " + id + " not found.");
    }
}

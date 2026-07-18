package com.ticketing.model;

public record Seat(Long id, Long venueId, String section, int row, int number) {
    
    public Seat {
        if(section == null || section.trim().isEmpty()) {
            throw new IllegalArgumentException("Section must not be empty");
        }
        if(!section.matches("[A-Z]+")) {
            throw new IllegalArgumentException("Section must be letters only");
        }
        if(row < 1) {
            throw new IllegalArgumentException("Row must be at least 1");
        }
        if(number < 1) {
            throw new IllegalArgumentException("Number must be at least 1");
        }
    }
}

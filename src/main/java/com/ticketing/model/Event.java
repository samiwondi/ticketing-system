package com.ticketing.model;

import java.time.LocalDateTime;

public record Event(
    Long id,
    Long venueId,
    String title,
    LocalDateTime startAt,
    LocalDateTime endAt,
    String status
) {
}
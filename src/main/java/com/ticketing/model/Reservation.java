package com.ticketing.model;

import java.time.LocalDateTime;

public record Reservation(
    Long id,
    Long eventId,
    String customerEmail,
    String status,
    LocalDateTime createdAt,
    LocalDateTime confirmedAt,
    LocalDateTime holdExpiresAt
) {
}
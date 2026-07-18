package com.ticketing.repository;

import com.ticketing.model.*;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryDataStore {

    // Maps to store data
    private final Map<Long, Venue> venues = new HashMap<>();
    private final Map<Long, Event> events = new LinkedHashMap<>();
    private final Map<Long, Seat> seats = new HashMap<>();
    private final Map<Long, Reservation> reservations = new HashMap<>();

    // ID counters
    private long venueIdCounter = 1;
    private long eventIdCounter = 1;
    private long seatIdCounter = 1;
    private long reservationIdCounter = 1;

    // ========== VENUE METHODS ==========

    public Venue saveVenue(Venue venue) {
        if (venue.id() == null) {
            Venue newVenue = new Venue(
                venueIdCounter++,
                venue.name(),
                venue.address(),
                venue.timezone()
            );
            venues.put(newVenue.id(), newVenue);
            return newVenue;
        }
        venues.put(venue.id(), venue);
        return venue;
    }

    public Optional<Venue> findVenueById(Long id) {
        return Optional.ofNullable(venues.get(id));
    }

    public List<Venue> findAllVenues() {
        return new ArrayList<>(venues.values());
    }

    // ========== EVENT METHODS ==========

    public Event saveEvent(Event event) {
        if (event.id() == null) {
            Event newEvent = new Event(
                eventIdCounter++,
                event.venueId(),
                event.title(),
                event.startAt(),
                event.endAt(),
                event.status()
            );
            events.put(newEvent.id(), newEvent);
            return newEvent;
        }
        events.put(event.id(), event);
        return event;
    }

    public Optional<Event> findEventById(Long id) {
        return Optional.ofNullable(events.get(id));
    }

    public List<Event> findAllEvents() {
        return new ArrayList<>(events.values());
    }

    public List<Event> findEventsByVenue(Long venueId) {
        return events.values().stream()
            .filter(event -> event.venueId().equals(venueId))
            .collect(Collectors.toList());
    }

    // ========== SEAT METHODS ==========

    public Seat saveSeat(Seat seat) {
        if (seat.id() == null) {
            Seat newSeat = new Seat(
                seatIdCounter++,
                seat.venueId(),
                seat.section(),
                seat.row(),
                seat.number()
            );
            seats.put(newSeat.id(), newSeat);
            return newSeat;
        }
        seats.put(seat.id(), seat);
        return seat;
    }

    public Optional<Seat> findSeatById(Long id) {
        return Optional.ofNullable(seats.get(id));
    }

    public List<Seat> findAllSeats() {
        return new ArrayList<>(seats.values());
    }

    public List<Seat> findSeatsByVenue(Long venueId) {
        return seats.values().stream()
            .filter(seat -> seat.venueId().equals(venueId))
            .collect(Collectors.toList());
    }

    // ========== RESERVATION METHODS ==========

    public Reservation saveReservation(Reservation reservation) {
        if (reservation.id() == null) {
            Reservation newReservation = new Reservation(
                reservationIdCounter++,
                reservation.eventId(),
                reservation.customerEmail(),
                reservation.status(),
                reservation.createdAt(),
                reservation.confirmedAt(),
                reservation.holdExpiresAt()
            );
            reservations.put(newReservation.id(), newReservation);
            return newReservation;
        }
        reservations.put(reservation.id(), reservation);
        return reservation;
    }

    public Optional<Reservation> findReservationById(Long id) {
        return Optional.ofNullable(reservations.get(id));
    }

    public List<Reservation> findAllReservations() {
        return new ArrayList<>(reservations.values());
    }

    public List<Reservation> findReservationsByEvent(Long eventId) {
        return reservations.values().stream()
            .filter(res -> res.eventId().equals(eventId))
            .collect(Collectors.toList());
    }

    // ========== UTILITY METHODS ==========

    public void clearAll() {
        venues.clear();
        events.clear();
        seats.clear();
        reservations.clear();
        venueIdCounter = 1;
        eventIdCounter = 1;
        seatIdCounter = 1;
        reservationIdCounter = 1;
    }

    // Getters for counters (used for persistence in Task D)
    public long getVenueIdCounter() { return venueIdCounter; }
    public long getEventIdCounter() { return eventIdCounter; }
    public long getSeatIdCounter() { return seatIdCounter; }
    public long getReservationIdCounter() { return reservationIdCounter; }
}
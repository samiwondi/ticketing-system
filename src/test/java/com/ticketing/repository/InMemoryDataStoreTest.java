package com.ticketing.repository;

import com.ticketing.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryDataStoreTest {

    private InMemoryDataStore dataStore;

    @BeforeEach
    void setUp() {
        dataStore = new InMemoryDataStore();
    }

    @Test
    void testSaveAndFindVenue() {
        Venue venue = dataStore.saveVenue(new Venue(null, "Stadium A", "123 Main St", "EST"));
        assertNotNull(venue.id());
        assertEquals("Stadium A", venue.name());

        Venue found = dataStore.findVenueById(venue.id()).orElse(null);
        assertNotNull(found);
        assertEquals(venue, found);
    }

    @Test
    void testSaveAndFindEvent() {
        Venue venue = dataStore.saveVenue(new Venue(null, "Stadium A", "123 Main St", "EST"));
        LocalDateTime now = LocalDateTime.now();
        Event event = dataStore.saveEvent(new Event(
            null,
            venue.id(),
            "Concert",
            now,
            now.plusHours(2),
            "SCHEDULED"
        ));

        assertNotNull(event.id());
        assertEquals("Concert", event.title());

        Event found = dataStore.findEventById(event.id()).orElse(null);
        assertNotNull(found);
        assertEquals(event, found);
    }

    @Test
    void testSaveAndFindSeat() {
        Venue venue = dataStore.saveVenue(new Venue(null, "Stadium A", "123 Main St", "EST"));
        Seat seat = dataStore.saveSeat(new Seat(
            null,
            venue.id(),
            "A",
            1,
            1
        ));

        assertNotNull(seat.id());
        assertEquals("A", seat.section());

        Seat found = dataStore.findSeatById(seat.id()).orElse(null);
        assertNotNull(found);
        assertEquals(seat, found);
    }

    @Test
    void testFindSeatsByVenue() {
        Venue venue = dataStore.saveVenue(new Venue(null, "Stadium A", "123 Main St", "EST"));
        dataStore.saveSeat(new Seat(null, venue.id(), "A", 1, 1));
        dataStore.saveSeat(new Seat(null, venue.id(), "A", 1, 2));
        dataStore.saveSeat(new Seat(null, venue.id(), "B", 1, 1));

        List<Seat> seats = dataStore.findSeatsByVenue(venue.id());
        assertEquals(3, seats.size());
    }

    @Test
    void testSaveAndFindReservation() {
        Venue venue = dataStore.saveVenue(new Venue(null, "Stadium A", "123 Main St", "EST"));
        LocalDateTime now = LocalDateTime.now();
        Event event = dataStore.saveEvent(new Event(
            null,
            venue.id(),
            "Concert",
            now,
            now.plusHours(2),
            "SCHEDULED"
        ));

        Reservation reservation = dataStore.saveReservation(new Reservation(
            null,
            event.id(),
            "customer@email.com",
            "HOLD",
            now,
            null,
            now.plusMinutes(15)
        ));

        assertNotNull(reservation.id());
        assertEquals("HOLD", reservation.status());

        Reservation found = dataStore.findReservationById(reservation.id()).orElse(null);
        assertNotNull(found);
        assertEquals(reservation, found);
    }

    @Test
    void testClearAll() {
        dataStore.saveVenue(new Venue(null, "Stadium A", "123 Main St", "EST"));
        dataStore.clearAll();
        assertEquals(0, dataStore.findAllVenues().size());
        assertEquals(0, dataStore.findAllEvents().size());
        assertEquals(0, dataStore.findAllSeats().size());
        assertEquals(0, dataStore.findAllReservations().size());
    }
}
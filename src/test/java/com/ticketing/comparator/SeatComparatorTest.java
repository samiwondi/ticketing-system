package com.ticketing.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ticketing.model.Seat;

public class SeatComparatorTest {

    @Test
    void testValidSeatCreation() {
        Seat seat = new Seat(null,null,"A",1,1);
        assertEquals("A", seat.section());
        assertEquals(1, seat.row());
        assertEquals(1, seat.number());
    }

    @Test
    void testInvalidSectionThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Seat(null,null,"",1,1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Seat(null,null,null,1,1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Seat(null,null,"1",1,1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Seat(null,null,"A1",1,1);
        });
    }

    @Test
    void testInvalidRowThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Seat(null,null,"A",-5,1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Seat(null,null,"Z",0,1);
        });
    }

    @Test
    void testInvalidNumberThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Seat(null,null,"A",1,-5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Seat(null,null,"A",1,0);
        });
    }

    @Test
    void testComparatorSortsCorrectly() {
        List<Seat> seats = Arrays.asList(
            new Seat(null,null,"B", 2, 3),
            new Seat(null,null, "A", 1, 1),
            new Seat(null,null,"A", 2, 1),
            new Seat(null,null,"B", 1, 2)
        );
        Collections.sort(seats, new SeatComparator());
        
        assertEquals("A", seats.get(0).section());
        assertEquals(1, seats.get(0).row());
        assertEquals(1, seats.get(0).number());
        
        assertEquals("B",seats.get(3).section());
        assertEquals(2, seats.get(3).row());
        assertEquals(3, seats.get(3).number());
    }
}

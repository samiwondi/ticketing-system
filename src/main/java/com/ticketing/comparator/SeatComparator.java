package com.ticketing.comparator;

import java.util.Comparator;

import com.ticketing.model.Seat;

public class SeatComparator implements Comparator<Seat> {
    @Override
    public int compare(Seat s1, Seat s2) {
        int sectionCompare = s1.section().compareTo(s2.section());
        if (sectionCompare != 0) return sectionCompare;
        int rowCompare = Integer.compare(s1.row(), s2.row());
        if (rowCompare != 0) return rowCompare;
        return Integer.compare(s1.number(), s2.number());
    }
}
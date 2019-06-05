package com.polyride;

import com.polyride.entity.TripListing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TripListingDepartureUnitTest {
    @Test
    public void tripDeparture_1() {
        TripListing listing = new TripListing();
        listing.setDeparture("SJ");
        assertEquals("SJ", listing.getDeparture());
    }

    @Test
    public void tripDestination_blank() {
        TripListing listing = new TripListing();
        listing.setDeparture("");
        assertEquals("", listing.getDeparture());
    }
}
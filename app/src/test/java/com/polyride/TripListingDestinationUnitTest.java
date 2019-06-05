package com.polyride;

import com.polyride.entity.TripListing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TripListingDestinationUnitTest {
    @Test
    public void tripDestination_1() {
        TripListing listing = new TripListing();
        listing.setDestination("SJ");
        assertEquals("SJ", listing.getDestination());
    }

    @Test
    public void tripDestination_blank() {
        TripListing listing = new TripListing();
        listing.setDestination("");
        assertEquals("", listing.getDestination());
    }
}
package com.polyride;

import com.polyride.entity.TripListing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TripListingAvailableSeatsUnitTest {
    @Test
    public void tripRemainingSeats_success() {
        TripListing listing = new TripListing();
        listing.setMaxPassengers(4);
        listing.setNumPassengers(1);
        Integer availableSeats = listing.getAvailableSeats();
        assertEquals(3, availableSeats.intValue());
    }

    @Test
    public void tripRemainingSeats_full() {
        TripListing listing = new TripListing();
        listing.setMaxPassengers(4);
        listing.setNumPassengers(4);
        Integer availableSeats = listing.getAvailableSeats();
        assertEquals(0, availableSeats.intValue());
    }
}
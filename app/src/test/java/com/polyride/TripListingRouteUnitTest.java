package com.polyride;

import com.polyride.entity.TripListing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TripListingRouteUnitTest {
    @Test
    public void tripRoute_success() {
        TripListing listing = new TripListing();
        listing.setDeparture("SJ");
        listing.setDestination("SLO");
        String route = listing.getRoute();
        assertEquals("SJ -> SLO", route);
    }

    @Test
    public void tripRoute_undefined() {
        TripListing listing = new TripListing();
        listing.setDeparture("");
        listing.setDestination("");
        String route = listing.getRoute();
        assertEquals("Undefined -> Undefined", route);
    }
}
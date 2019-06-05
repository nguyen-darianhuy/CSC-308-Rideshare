package com.polyride;

import com.polyride.entity.TripListing;
import com.polyride.entity.User;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TripListingDriverUnitTest {
    @Test
    public void tripDriver_1() {
        TripListing listing = new TripListing();
        User driver = new User("name", "bio", "email", "number", "departureCity", "arrivalCity");
        listing.setDriver(driver);
        assertEquals(driver, listing.getDriver());
    }

    @Test
    public void tripDriver_null() {
        TripListing listing = new TripListing();
        listing.setDriver(null);
        assertEquals(null, listing.getDriver());
    }
}
package com.polyride;

import com.polyride.entity.User;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserArrivalUnitTest {
    @Test
    public void arrivalSuccess() {
        User user = new User();
        user.setArrivalCity("San Jose");
        String arrival = user.getArrivalCity();
        assertEquals(arrival, "San Jose");
    }

    @Test
    public void arrivalSuccess2() {
        User user = new User();
        user.setArrivalCity("Elk Grove");
        String arrival = user.getArrivalCity();
        assertEquals(arrival, "Elk Grove");
    }
}

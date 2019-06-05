package com.polyride;

import com.polyride.entity.User;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserDepartureUnitTest {
    @Test
    public void depatureSuccess() {
        User user = new User();
        user.setDepartureCity("SLO");
        String departure = user.getDepartureCity();
        assertEquals("SLO", departure);
    }

    @Test
    public void depatureSuccess2() {
        User user = new User();
        user.setDepartureCity("Sacramento");
        String departure = user.getDepartureCity();
        assertEquals("Sacramento", departure);
    }
}

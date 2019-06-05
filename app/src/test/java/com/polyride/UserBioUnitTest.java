package com.polyride;

import com.polyride.entity.User;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserBioUnitTest {
    @Test
    public void bioSuccess() {
        User user = new User();
        user.setBio("Ride with me pls I'm funny I swear");
        String bio = user.getBio();
        assertEquals("Ride with me pls I'm funny I swear", bio);
    }

    @Test
    public void bioSuccess2() {
        User user = new User();
        user.setBio("Raptors in 7");
        String bio = user.getBio();
        assertEquals("Raptors in 7", bio);
    }
}

package com.polyride;

import com.polyride.entity.User;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserEmailUnitTest {
    @Test
    public void emailSuccess() {
        User user = new User();
        user.setEmail("nctu@calpoly.edu");
        String email = user.getEmail();
        assertEquals("nctu@calpoly.edu", email);
    }

    @Test
    public void emailSuccess2() {
        User user = new User();
        user.setEmail("mpatacsil@calpoly.edu");
        String email = user.getEmail();
        assertEquals("mpatacsil@calpoly.edu",email);
    }
}

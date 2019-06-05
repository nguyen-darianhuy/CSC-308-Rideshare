package com.polyride;

import com.polyride.entity.User;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserNameUnitTest {
    @Test
    public void nameSuccess() {
        User user = new User();
        user.setName("John Doe");
        String name = user.getName();
        assertEquals("John Doe", name);
    }

    @Test
    public void nameSuccess2() {
        User user = new User();
        user.setName("Davide Falessi");
        String name = user.getName();
        assertEquals("Davide Falessi", name);
    }
}

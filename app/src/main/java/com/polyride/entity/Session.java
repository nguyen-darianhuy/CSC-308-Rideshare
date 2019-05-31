package com.polyride.entity;

public class Session {
    private static String currentUserId = null;
    public static String getCurrentUserId() {
        return currentUserId;
    }

    public static void setCurrentUserId(String userId) {
        currentUserId = userId;
    }
}

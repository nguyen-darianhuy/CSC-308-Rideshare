package com.polyride;

import com.polyride.entity.Review;
import com.polyride.entity.TripListing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReviewContentUnitTest {
    @Test
    public void reviewContent_1() {
        Review review = new Review();
        review.setComment("asdf");

        assertEquals("asdf", review.getComment());
    }

    @Test
    public void reviewContent_blank() {
        Review review = new Review();
        review.setComment("");

        assertEquals("", review.getComment());
    }
}

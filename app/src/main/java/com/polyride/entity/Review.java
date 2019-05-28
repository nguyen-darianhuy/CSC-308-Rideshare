package com.polyride.entity;

public class Review {

    public Integer reviewId;
    public Integer reviewerId;
    public Integer revieweeId;
    public String comment;
    public Integer rating;

    public Review() {}

    public Review(Integer reviewId, Integer reviewerId, Integer revieweeId, String content, Integer rating){
        this.reviewId = reviewId;
        this.reviewerId = reviewerId;
        this.revieweeId = revieweeId;
        this.comment = content;
        this.rating = rating;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Integer getRevieweeId() {
        return revieweeId;
    }

    public void setRevieweeId(Integer revieweeId) {
        this.revieweeId = revieweeId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
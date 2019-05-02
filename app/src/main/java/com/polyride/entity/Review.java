package com.polyride.entity;
public class Review {

    private User reviewer;
    private User reviewee;
    private String comment;

    public Review(User reviewer, User reviewee, String content){
        this.reviewer = reviewer;
        this.reviewee = reviewee;
        this.comment = content;
    }

}
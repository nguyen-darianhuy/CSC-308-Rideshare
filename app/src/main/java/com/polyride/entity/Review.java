package com.polyride.entity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(foreignKeys = {@ForeignKey(entity = Users.class,
                            parentColumns = "userId",
                            childColumns = "reviewerId"),
                       @ForeignKey(entity = Users.class,
                            parentColumns = "userId",
                            childColumns = "revieweeId")})
public class Review {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "reviewId")
    private int reviewId;

    @ColumnInfo(name = "reviewerId")
    private int reviewerId;

    @ColumnInfo(name = "revieweeId")
    private int revieweeId;

    @ColumnInfo(name = "comment")
    private String comment;

    @ColumnInfo(name = "rating")
    private int rating;

    public Review(int reviewId, int reviewerId, int revieweeId, String content, int rating){
        this.reviewId = reviewId;
        this.reviewerId = reviewerId;
        this.revieweeId = revieweeId;
        this.comment = content;
        this.rating = rating;
    }


    public int getReviewId() {
        return reviewId;
    }
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getReviewerId() {
        return reviewerId;
    }
    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }

    public int getRevieweeId() {
        return revieweeId;
    }
    public void setRevieweeId(int revieweeId) {
        this.revieweeId = revieweeId;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
}
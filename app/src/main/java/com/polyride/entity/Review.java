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
    private Integer reviewId;

    @ColumnInfo(name = "reviewerId")
    private Integer reviewerId;

    @ColumnInfo(name = "revieweeId")
    private Integer revieweeId;

    @ColumnInfo(name = "comment")
    private String comment;

    @ColumnInfo(name = "rating")
    private Integer rating;

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
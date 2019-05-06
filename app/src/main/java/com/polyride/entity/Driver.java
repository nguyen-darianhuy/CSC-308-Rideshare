package com.polyride.entity;
import java.util.*;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(foreignKeys = {@ForeignKey(entity = Users.class,
                parentColumns = "userId",
                childColumns = "userId"),
        @ForeignKey(entity = Car.class,
                parentColumns = "carId",
                childColumns = "carId")})
public class Driver {

    @NonNull
    @ColumnInfo(name = "userId")
    public int userId;
    @ColumnInfo(name = "cardId")
    public int carId;


    public List<Integer> plannedTrips;

    public Driver() {

    }
    public void addListing(Integer t){
        plannedTrips.add(t);
    }
    public void editListing(TripListing t){ }
    public void deleteListing(TripListing t){ }
}
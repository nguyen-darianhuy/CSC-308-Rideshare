package com.polyride.controller;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;

import com.polyride.entity.TripListing;

@Dao
public interface TripListingDao {

    @Query("SELECT * FROM TripListing")
    LiveData<TripListing> loadAllListings();

    @Query("SELECT * FROM TripListing LIMIT 5")
    LiveData<TripListing> loadFirstFiveListings();

    @Insert
    void insertListing(TripListing listing);

    @Delete
    void deleteListing(TripListing listing);


}

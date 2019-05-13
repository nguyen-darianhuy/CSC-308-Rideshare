package com.polyride.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;

import com.polyride.entity.TripListing;
import java.util.List;

@Dao
public interface TripListingDao {

    @Query("SELECT * FROM TripListing")
    List<TripListing> loadAllListings();

    @Query("SELECT * FROM TripListing LIMIT 5")
    List<TripListing> loadFirstFiveListings();

    @Insert
    void insertListing(TripListing listing);

    @Delete
    void deleteListing(TripListing listing);


}

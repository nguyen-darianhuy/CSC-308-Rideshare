package com.polyride.controller;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;

import com.polyride.entity.Driver;

@Dao
public interface DriverDao {

    @Query("SELECT * FROM Driver")
    LiveData<Driver> loadAllDrivers();

    @Query("SELECT * FROM Driver LIMIT 5")
    LiveData<Driver> loadFirstFiveDrivers();

    @Insert
    void insertDriver(Driver driver);

    @Delete
    void deleteDriver(Driver driver);
}

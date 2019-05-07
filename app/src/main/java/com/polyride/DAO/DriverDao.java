package com.polyride.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;

import com.polyride.entity.Driver;
import java.util.List;

@Dao
public interface DriverDao {

    @Query("SELECT * FROM Driver")
    List<Driver> loadAllDrivers();

    @Query("SELECT * FROM Driver LIMIT 5")
    List<Driver> loadFirstFiveDrivers();

    @Insert
    void insertDriver(Driver driver);

    @Delete
    void deleteDriver(Driver driver);
}

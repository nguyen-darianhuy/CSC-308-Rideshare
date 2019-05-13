package com.polyride.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;

import com.polyride.entity.Car;
import java.util.List;

@Dao
public interface CarDao {

    @Query("SELECT * FROM CarTable")
    List<Car> loadAllCars();

    @Insert
    void insertCar(Car car);

    @Delete
    void deleteCar(Car car);
}

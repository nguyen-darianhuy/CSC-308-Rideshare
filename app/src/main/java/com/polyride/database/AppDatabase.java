package com.polyride.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.polyride.DAO.*;
import com.polyride.entity.*;

@Database(entities = {Login.class, Users.class, TripListing.class, Driver.class, Car.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract LoginDao loginDao();
    public abstract UsersDao usersDao();
    public abstract TripListingDao tlDao();
    public abstract DriverDao driverDao();

    private static AppDatabase DBINSTANCE;

    /*
    public static AppDatabase getDatabase(final Context context) {
        if (DBINSTANCE == null) {
            synchronized(AppDatabase.class) {
                if (DBINSTANCE == null) {
                    DBINSTANCE = Room.databaseBuilder(
                            context, AppDatabase.class, "LOGIN_DATABASE")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return DBINSTANCE;
    }*/
}

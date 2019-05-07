package com.polyride.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.polyride.DAO.*;
import com.polyride.entity.*;

@Database(entities = {Login.class, Users.class, TripListing.class, Driver.class}, version = 1, exportSchema = false)
public abstract class LoginDatabase extends RoomDatabase {
    public abstract LoginDao loginDao();
    public abstract UsersDao usersDao();
    public abstract TripListingDao tlDao();
    public abstract DriverDao driverDao();

    private static LoginDatabase DBINSTANCE;

    public static LoginDatabase getDatabase(final Context context) {
        if (DBINSTANCE == null) {
            synchronized(LoginDatabase.class) {
                if (DBINSTANCE == null) {
                    DBINSTANCE = Room.databaseBuilder(
                            context, LoginDatabase.class, "LOGIN_DATABASE")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return DBINSTANCE;
    }
}

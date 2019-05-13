package com.polyride.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;

import com.polyride.entity.Users;
import java.util.List;

@Dao
public interface UsersDao {

    @Query("SELECT * FROM UsersTable")
    List<Users> getAllUsers();

    @Query("SELECT * FROM UsersTable WHERE userId = :userId")
    List<Users> getLoginById(Integer userId);

    @Insert
    void insertLogin(Users user);

    @Delete
    void deleteLogin(Users user);

}

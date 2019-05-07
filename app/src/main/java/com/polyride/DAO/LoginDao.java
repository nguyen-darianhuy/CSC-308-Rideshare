package com.polyride.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;

import com.polyride.entity.Login;
import java.util.List;

@Dao
public interface LoginDao {

    @Query("SELECT * FROM LoginTable")
    List<Login> getAllLogins();

    @Query("SELECT * FROM LoginTable WHERE profId = :profId")
    List<Login> getLoginById(Integer profId);

    @Insert
    void insertLogin(Login login);

    @Delete
    void deleteLogin(Login login);

}

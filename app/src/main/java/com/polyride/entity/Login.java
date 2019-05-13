package com.polyride.entity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "LoginTable")
public class Login {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "profId")
    public Integer profId;

    @NonNull
    @ColumnInfo(name = "username")
    public String username;

    @NonNull
    @ColumnInfo(name = "password")
    public String password;

    @NonNull
    @ColumnInfo(name = "email")
    public String email;

    public Login(String username, String password, String email, Integer profId){
        this.username = username;
        this.password = password;
        this.email = email;
        this.profId = profId;
    }

    public String requestUsername(){ return this.username; }

    public String requestPassword(){ return this.password; }

    public String getEmail() { return this.email; }

    public int getProfileID() { return this.profId; }

    public void connect(String username, String password){ //TODO
    }

}
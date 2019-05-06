package com.polyride.entity;
import android.support.annotation.*;
@Entity
public class Login {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = 'profId')
    public int profile;

    @NonNull
    @ColumnInfo(name = 'username')
    public String username;

    @NonNull
    @ColumnInfo(name = 'password')
    public String password;

    @NonNull
    @ColumnInfo(name = 'email')
    public String email;

    @Ignore
    public Login(String un, String pw, String em, int profId){
        this.username = un;
        this.password = pw;
        this.email = em;
        this.profile = profId;
    }

    public String requestUsername(){ return this.username; }

    public String requestPassword(){ return this.password; }

    public String getEmail() { return this.email; }

    public int getProfileID() { return this.profile; }

    public void connect(String username, String password){ return; }

}
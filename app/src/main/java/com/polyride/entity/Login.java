package com.polyride.entity;

public class Login {

    private Integer profId;
    private String username;
    private String password;
    private String email;

    public Login() {}

    public Login(String username, String password, String email, Integer profId){
        this.username = username;
        this.password = password;
        this.email = email;
        this.profId = profId;
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
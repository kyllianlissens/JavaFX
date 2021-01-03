package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    public User(){} //Empty constructor for Jackson

    public User(String username, String password, int highscore){
        this.username = username;
        this.password = password;
        this.highscore = highscore;
    }

    public User(String username, String password){
        this(username, password, 0);
    }



    private String username;
    private String password;
    private int highscore;


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

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", highscore=" + highscore +
                '}';
    }
}
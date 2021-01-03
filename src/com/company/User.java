package com.company;

public class User {
   private String username;
   private String wachtwoord;
   private int highscore;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
    public String toCSV(String seperator){
        return username + seperator + wachtwoord + seperator + highscore;
    }
}

package com.cinema.Model;

public abstract class userPassword {
    
    private String password;


    public userPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}

package com.sidgs.odp.model;

/**
 * Created by SUNIL PC on 16-08-2017.
 */
//This class represents the data model that is sent by UI
public class AuthenticateInfoUI {

    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

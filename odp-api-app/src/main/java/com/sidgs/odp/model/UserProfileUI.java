package com.sidgs.odp.model;

/**
 * Created by SUNIL PC on 16-08-2017.
 */
//This class represents data model sent to UI on successfull authentication
public class UserProfileUI {

    String email;
    String fname;
    String lname;
    String role;

    public UserProfileUI() {
    }

    public UserProfileUI(String email, String fname, String lname, String role) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

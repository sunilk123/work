package com.sunil;

import javax.persistence.*;

/**
 * Created by SUNIL PC on 28-07-2017.
 */
@Entity
@Table(name = "Admin_Login", schema = "dbo", catalog = "ParkingService")
public class AdminLoginEntity {
    private String username;
    private String password;
    private int adminid;

    @Basic
    @Column(name = "username", nullable = false, length = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @Column(name = "adminid", nullable = false)
    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminLoginEntity that = (AdminLoginEntity) o;

        if (adminid != that.adminid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + adminid;
        return result;
    }

    @Override
    public String toString() {
        return "AdminLoginEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", adminid=" + adminid +
                '}';
    }
}

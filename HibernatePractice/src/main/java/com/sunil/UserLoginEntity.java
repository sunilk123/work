package com.sunil;

import javax.persistence.*;

/**
 * Created by SUNIL PC on 28-07-2017.
 */
@Entity
@Table(name = "User_Login", schema = "dbo", catalog = "ParkingService")
public class UserLoginEntity {
    private int userid;
    private String username;
    private String passsword;
    private AdminLoginEntity adminLoginByAdminUserId;

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "passsword", nullable = false, length = 30)
    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLoginEntity that = (UserLoginEntity) o;

        if (userid != that.userid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (passsword != null ? !passsword.equals(that.passsword) : that.passsword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (passsword != null ? passsword.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "admin_user_id", referencedColumnName = "adminid", nullable = false)
    public AdminLoginEntity getAdminLoginByAdminUserId() {
        return adminLoginByAdminUserId;
    }

    public void setAdminLoginByAdminUserId(AdminLoginEntity adminLoginByAdminUserId) {
        this.adminLoginByAdminUserId = adminLoginByAdminUserId;
    }
}

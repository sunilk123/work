package com.sidgs.odp.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by SUNIL PC on 16-08-2017.
 */
/*
This class defines the relationship between the User, Role and Organization
*/
@Document(collection="user-org-role-map")
public class UserOrgRoleMapping {

    String nameOfOrg;
    String RoleName;
    String email;

    public UserOrgRoleMapping() {
    }

    public UserOrgRoleMapping(String email) {
        this.email = email;
    }

    public String getNameOfOrg() {
        return nameOfOrg;
    }

    public void setNameOfOrg(String nameOfOrg) {
        this.nameOfOrg = nameOfOrg;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.sidgs.odp.api.service;

/**
 * Created by SUNIL PC on 16-08-2017.
 */
public interface UserOrgRoleMapService {
    //To check User role
    boolean IsSysAdmin();
    //to retrieve user role
    String getUserRole(String email);
}

package com.sidgs.odp.api.service;

import com.sidgs.odp.api.error.UserInfoException;
import com.sidgs.odp.error.BaseException;
import com.sidgs.odp.model.Alias;
import com.sidgs.odp.model.UserInfo;

import java.util.List;

/**
 * Created by kalya on 5/28/2017.
 */


public interface UserInfoService {
    List<UserInfo> getAll() throws UserInfoException;
    UserInfo getUser(String email) throws UserInfoException;
    String createUser(UserInfo userInfo) throws UserInfoException;
    String updateUser(String email) throws UserInfoException;
    String deleteUser(String email) throws UserInfoException;
    void updateWithAlias(UserInfo userInfo , Alias alias) throws BaseException;


}

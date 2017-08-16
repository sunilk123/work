package com.sidgs.odp.api.service;

import com.sidgs.odp.model.UserInfo;
import com.sidgs.odp.api.error.LoginDetailsConflictException;
import com.sidgs.odp.model.EnteredLoginDetails;

/**
 * Created by saiManoj on 5/19/2017.
 */


public interface AuthenticationService  {

    boolean authenticate(UserInfo userInfo, EnteredLoginDetails enteredLoginDetails) throws LoginDetailsConflictException;
}

package com.sidgs.odp.api.service;


import com.sidgs.odp.api.error.LoginDetailsConflictException;
import com.sidgs.odp.api.error.UserNameNotFoundException;
import com.sidgs.odp.model.EnteredLoginDetails;
import com.sidgs.odp.model.UserInfo;
import com.sidgs.odp.repository.AuthenticationRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kalya on 5/18/2017.
 */

@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    @Autowired
    private AuthenticationRepository authenticationRepository;

    Log logger = LogFactory.getLog(this.getClass());

    @Override
    public boolean authenticate(UserInfo userInfo, EnteredLoginDetails enteredLoginDetails)
            throws LoginDetailsConflictException {
        UserInfo fetchedUserInfo = new UserInfo();
        boolean authenticationStatus = false;
        try{
            fetchedUserInfo = authenticationRepository.findByUsername(enteredLoginDetails.getUsername());
            if(fetchedUserInfo == null){
                throw new UserNameNotFoundException("", "");
            }
            if(fetchedUserInfo != null){
                if(fetchedUserInfo.getPassword().equals(enteredLoginDetails.getPassword())){

                    authenticationStatus = true;
                    return authenticationStatus;
                }
                else{
                    return authenticationStatus;
                }
            }

        }
        catch(UserNameNotFoundException e){
            logger.error("Error occured while fetching the UserInfo Object with" +
                    " Entered Username"+enteredLoginDetails.getUsername(),e);
            throw new LoginDetailsConflictException(e,"HTTP_401","Entered Username is not registered");

        }

       catch(Exception e){
        logger.error("error thrown while logging in with User Name"+enteredLoginDetails.getUsername() +
                " and Password"
        +enteredLoginDetails.getPassword());
           throw new LoginDetailsConflictException(e ," HTTP_401 "," Username and Password Doesnot Match ");
       }
       finally {
           return authenticationStatus;
       }
    }
}

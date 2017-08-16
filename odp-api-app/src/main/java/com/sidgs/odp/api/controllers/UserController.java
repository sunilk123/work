package com.sidgs.odp.api.controllers;

import com.sidgs.odp.api.error.UserAlreadyPresentException;
import com.sidgs.odp.api.error.UserInfoException;
import com.sidgs.odp.api.error.UserLoginException;
import com.sidgs.odp.api.service.UserInfoService;
import com.sidgs.odp.api.service.UserOrgRoleMapService;
import com.sidgs.odp.error.BaseException;
import com.sidgs.odp.model.Alias;
import com.sidgs.odp.model.AuthenticateInfoUI;
import com.sidgs.odp.model.UserInfo;
import com.sidgs.odp.model.UserProfileUI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by ayeluri on 5/28/2017.
 */
@RestController
@RequestMapping("users")

public class UserController {

    //Temp only
    //TODO replace with userService

    static Map<String, UserInfo> userInfoMap = new HashMap<String, UserInfo>();

    Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    UserInfoService userInfoService ;

    @Autowired
    UserOrgRoleMapService userorgrolemapservice;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String create(@RequestBody @Valid UserInfo userInfo) throws BaseException {


        try {
            if ( userInfoService.getUser(userInfo.getEmail()) != null )
                throw new UserAlreadyPresentException();
        } catch (UserInfoException e) {
           throw new BaseException(e, "",e.getLocalizedMessage());
        }

        if (userInfo.getEmail() == null ) throw new BaseException("User is null", "User is null");

        logger.info("create user : " + userInfo.getEmail());
//        userInfoMap.put(userInfo.getEmail(), userInfo);
        try {
            userInfoService.createUser(userInfo);
            return "{\"success\": true}";
        } catch (UserInfoException e) {
            throw new BaseException(e, "","Error Creating User");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, path = "/authenticate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserProfileUI auth (@RequestBody @Valid AuthenticateInfoUI userentereddetails) throws BaseException, UserLoginException {

        try {
            UserInfo userInfo1 =  userInfoService.getUser(userentereddetails.getEmail());

            if ( userInfo1 != null &&
                userInfo1.getPassword().equals(userentereddetails.getPassword())) {
                return new UserProfileUI(userInfo1.getEmail(),userInfo1.getFname(),userInfo1.getLname(),userorgrolemapservice.getUserRole(userInfo1.getEmail()));
            }
            else throw new UserLoginException("Login Failed", "401");
        } catch (Exception e) {
            throw new BaseException(e, "401",e.getLocalizedMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET , path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public @ResponseBody UserInfo get0UserbyUsername(
            @PathVariable("id") String id ) throws BaseException {
        logger.info("get user with id: " + id);

        try {
            return  userInfoService.getUser(id);
        } catch (UserInfoException e) {
            logger.error(e, e);
            throw new BaseException("HTTP_404","User Not Found");
        }

    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET , path = "/id/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public @ResponseBody UserInfo getUserbyId(@PathVariable("id") String id ) throws BaseException {
        logger.info("get user with id: " + id);

        try {
            return  userInfoService.getUser(id);
        } catch (UserInfoException e) {
            logger.error(e, e);
            throw new BaseException("HTTP_404","User Not Found");
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Collection<UserInfo> getUsers() throws BaseException {
        logger.info("get all users  " );

        Collection<UserInfo> usersWithPwd = null;
        try {
            usersWithPwd = userInfoService.getAll();
        } catch (Exception e) {
            logger.warn(e,e);
        }

        List<UserInfo> userListwithoutPassword = new ArrayList<UserInfo>();
        for ( UserInfo userInfo: usersWithPwd) {
            userInfo.setPassword("******");
            userListwithoutPassword.add(userInfo);
        }

        return userListwithoutPassword;

    }


    @RequestMapping(path = "/user/{id}/alias" ,
            method = RequestMethod.PUT)
    public void updateWithAlias(@PathVariable("id") String userid , @RequestBody Alias alias) throws UserInfoException {
        try{
            logger.info("adding alias "+alias.getId() + " to User");
            userInfoService.updateWithAlias(userInfoService.getUser(userid),alias);
            logger.info("Successfully added");
        }
        catch (Exception e){
            logger.error("error occured while associating alias with id "+alias.getId()+"" +
                    " to user with id "+userid);
        }

    }

    public void addkpi (String user, String kpi ) {

    }

}

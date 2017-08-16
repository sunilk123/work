package com.sidgs.odp.api.controllers;

import com.sidgs.odp.api.error.UserAlreadyPresentException;
import com.sidgs.odp.error.BaseException;
import com.sidgs.odp.model.UserInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

/**
 * Created by ayeluri on 5/28/2017.
 */
@RestController
@RequestMapping("echo")

public class EchoController {

    //Temp only
    //TODO replace with userService

    static Map<String, UserInfo> userInfoMap = new HashMap<String, UserInfo>();

    Log logger = LogFactory.getLog(this.getClass());

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody String userInfo) throws BaseException {
        logger.info(userInfo);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(String userInfo) throws BaseException {
        logger.info(userInfo);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete (String userInfo) throws BaseException {
        logger.info(userInfo);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsers(String request ) throws BaseException {

        return request;

    }


}

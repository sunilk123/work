package com.sidgs.odp.api.controllers;

import com.sidgs.odp.api.service.BulkLoaderService;
import com.sidgs.odp.error.BaseException;
import com.sidgs.odp.model.AreaOfInterest;
import com.sidgs.odp.model.Role;
import com.sidgs.odp.model.Team;
import com.sidgs.odp.model.UserInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Used to bulk Load AoI, KPI, Role, Team, User
 */
@RestController
@RequestMapping("load")
public class BulkLoaderController {

    Log logger = LogFactory.getLog(this.getClass());


    @Autowired
    BulkLoaderService bulkLoaderService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, path = "users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    String createUsers(@RequestBody @Valid List<UserInfo> userInfoList) throws BaseException {

        Log logger = LogFactory.getLog(this.getClass());

            bulkLoaderService.createUsers(userInfoList);

        return "{\"success\": true}";

    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, path = "teams",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    String createTeams(@RequestBody @Valid List<Team> teamList) throws BaseException {

        Log logger = LogFactory.getLog(this.getClass());

        return bulkLoaderService.createTeams(teamList);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, path = "roles",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    String createRole(@RequestBody @Valid List<Role> roleList ) throws BaseException {
        return bulkLoaderService.createRole(roleList);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, path = "aoi",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    String createAreaOfInterest(@RequestBody @Valid List<AreaOfInterest> areaOfInterestList ) throws BaseException {
        return bulkLoaderService.createAreaOfInterest(areaOfInterestList);
    }

}
package com.sidgs.odp.api.service;

import com.sidgs.odp.error.BaseException;
import com.sidgs.odp.model.AreaOfInterest;
import com.sidgs.odp.model.Role;
import com.sidgs.odp.model.Team;
import com.sidgs.odp.model.UserInfo;

import java.util.List;

/**
 * Created by ryarakaraju on 7/8/17.
 */
public interface BulkLoaderService {

    public String createUsers(List<UserInfo> userInfoList) throws BaseException;

    public String createTeams(List<Team> teamList) throws BaseException;

    public String createRole(List<Role> roleList ) throws BaseException;

    public String createAreaOfInterest(List<AreaOfInterest> areaOfInterestList) throws BaseException;

}

package com.sidgs.odp.api.service;

import com.sidgs.odp.error.BaseException;
import com.sidgs.odp.model.AreaOfInterest;
import com.sidgs.odp.model.Role;
import com.sidgs.odp.model.Team;
import com.sidgs.odp.model.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ryarakaraju on 7/8/17.
 */
@Service
public class BulkLoaderServiceImpl implements BulkLoaderService{
    @Override
    public String createUsers(List<UserInfo> userInfoList) throws BaseException {
        return null;
    }

    @Override
    public String createTeams(List<Team> teamList) throws BaseException {
        return null;
    }

    @Override
    public String createRole(List<Role> roleList) throws BaseException {
        return null;
    }

    @Override
    public String createAreaOfInterest(List<AreaOfInterest> areaOfInterestList) throws BaseException {
        return null;
    }
}

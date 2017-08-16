package com.sidgs.odp.api.service;

import com.sidgs.odp.model.UserOrgRoleMapping;
import com.sidgs.odp.repository.UserInfoRepository;
import com.sidgs.odp.repository.UserOrgRoleMapRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SUNIL PC on 16-08-2017.
 */
@Service
public class UserorgRoleMapserviceImpl implements UserOrgRoleMapService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserorgRoleMapserviceImpl.class);


    @Autowired
    UserInfoRepository userInfoRepository;
    Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserOrgRoleMapRepository userorgrolemaprepo;

    @Override
    public boolean IsSysAdmin() {
        return false;
    }

    @Override
    public String getUserRole(String email) {
        //Example<UserOrgRoleMapping> example=Example.of(new UserOrgRoleMapping(email));
        log.info("Getting User Role");
        List<UserOrgRoleMapping> userorgrolemap=userorgrolemaprepo.findAll();
        for (UserOrgRoleMapping temp: userorgrolemap
             ) {
            if(temp.getEmail().equals(email))
                return temp.getRoleName();
            
        }
        return null;
    }
}

package com.sidgs.odp.api.service;

import com.sidgs.odp.api.error.UserInfoException;
import com.sidgs.odp.model.Alias;
import com.sidgs.odp.model.UserInfo;
import com.sidgs.odp.repository.UserInfoRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by kalya on 5/28/2017.
 */
@Service
public class UserInfoServiceImpl  implements UserInfoService{

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserInfoServiceImpl.class);


    @Autowired
    UserInfoRepository userInfoRepository;
    Log logger = LogFactory.getLog(this.getClass());

    @Override
    public List<UserInfo> getAll() throws UserInfoException {
        log.info("Trying to pull all users from Database");
        List<UserInfo> target=null;
        try {
            Iterable<UserInfo> list = userInfoRepository.findAll();
            target = new ArrayList<UserInfo>();
            list.forEach(target::add);
            return target;
        }catch (Exception e){
            log.error("Unknown Exception Ocuured in retrieving Data from dataBase",e);
            throw new UserInfoException("error Ocuures","HTTP_500");
        }
    }

    @Override
    public UserInfo getUser(String email) throws UserInfoException {
        log.info("Getting UserInfo ");
        if(email!=null){
            try {
                UserInfo userinfo = userInfoRepository.findOne(email);
                return userinfo;
            }catch(Exception e){
                log.error("exception occurred in retrieving UserInfo",e);
                throw new UserInfoException("exception occurred","HTTP_500");
            }
        }else{
            log.error("user email has null value");
            throw new UserInfoException("UserEmail value is null","");
        }

    }

//    @Override
//    public UserInfo getByUserName(String userName) {
//        return null;
//    }

    @Override
    public String createUser(UserInfo userInfo) throws UserInfoException {
        log.info("Saving New UserInfo Entity");
        if(userInfo!=null){
            try {
                if (userInfo.getGuid()== null ) userInfo.setGuid(UUID.randomUUID().toString());
                UserInfo userinfo = userInfoRepository.save(userInfo);
                return "Success";
            }catch(Exception e){
                log.error("exception occurred in retrieving UserInfo",e);
                throw new UserInfoException("exception occurred in creating new User","HTTP_500");
            }
        }else{
            log.error("UserInfo object has a null value");
            throw new UserInfoException("User Object value is null","");
        }
    }

    @Override
    public String updateUser(String email) throws UserInfoException {
        log.info("Updating Existing UserInfo Entity");
        UserInfo userInfo;
        try{
            log.info("Finding out the UserInfo entity based on username");
            userInfo = userInfoRepository.findOne(email);
            if(userInfo!=null){
                userInfoRepository.delete(userInfo.getEmail());
                userInfoRepository.save(userInfo);
                return "Success";
            }else{
                log.error("No User existed with username"+email);
                throw new UserInfoException("Username does not match");
            }
        }catch(Exception e){
            throw new UserInfoException("error occured in updating user","HTTP_500");
        }

    }

    @Override
    public String deleteUser(String email) throws UserInfoException {
        log.info(" Deleting UserInfo Entity");
        UserInfo userInfo;
        try{
            log.info("Finding out the UserInfo entity based on username");
            userInfo = userInfoRepository.findOne(email);
            if(userInfo!=null){
                userInfoRepository.delete(userInfo.getEmail());
                return "Success";
            }else{
                log.error("No User existed with username"+email);
                throw new UserInfoException("Username does not match");
            }
        }catch(Exception e){
            throw new UserInfoException("error occured in updating user","HTTP_500");
        }
    }

    @Override
    public void updateWithAlias(UserInfo userInfo, Alias alias)   {
        try{
            UserInfo userInfo1 = userInfoRepository.findOne(userInfo.getEmail());

            if(userInfo1 == null)
                throw new UserInfoException("User with the name "+userInfo.getFname()+" not present");
            else{
                if(alias.getSystem() ==null && alias.getId() ==null && alias.getInstanceId() == null)
                    throw new UserInfoException("Fields in Alias cannot be null");
                else{
                    if(userInfo1.getUserAliasList().contains(alias))
                        throw new UserInfoException("Alias already exsit");
                    else{
                        userInfo1.getUserAliasList().add(alias);
                        userInfoRepository.save(userInfo1);
                    }
                }
            }

        }
        catch(Exception e){
            logger.error("error occured while updating alias with id "+alias.getId()+" to " +
                    "userinfo with email "+userInfo.getEmail(),e);
        }
    }
}

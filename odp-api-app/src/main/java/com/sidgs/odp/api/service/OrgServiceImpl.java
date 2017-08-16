package com.sidgs.odp.api.service;

import com.sidgs.odp.api.error.OrgException;
import com.sidgs.odp.model.Org;
import com.sidgs.odp.repository.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kalya on 6/26/2017.
 */
public class OrgServiceImpl implements OrgService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OrgServiceImpl.class);
    @Autowired
    OrgRepository orgRepository;

    @Override
    public void saveOrganizaion(Org org) throws OrgException {

        log.info("trying to save the new Organization name");
        if(orgRepository.findOne(org.getNameOfOrg())==null){
            try {
                orgRepository.save(org);
            }catch(Exception e){
                log.error("Error Occured in saving new Org"+org.getNameOfOrg());
            }
        }else{
            throw new OrgException(org.getNameOfOrg()+"already exists","");
        }
    }

    @Override
    public void enableOrg(String orgName) throws OrgException {
        log.info("trying to enable Org");
        if(orgRepository.findOne(orgName)!=null){
            try{
                Org org = orgRepository.findOne(orgName);



            }catch(Exception e){

            }

        }else{

            throw new OrgException(orgName+"does not  exists","");

        }
    }

    @Override
    public void disableOrg(Org org) {

    }
}

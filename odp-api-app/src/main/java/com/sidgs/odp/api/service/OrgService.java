package com.sidgs.odp.api.service;

import com.sidgs.odp.api.error.OrgException;
import com.sidgs.odp.model.Organization;

import java.util.List;

/**
 * Created by kalya on 6/26/2017.
 */
public interface OrgService {

    // Saving new Organization
    void saveOrganizaion(Organization org) throws Exception;

    //make an Org Active

    void enableOrg(String orgName) throws OrgException;

    //diasable org

    void disableOrg(Organization org);

    List<Organization> getAll();

}

package com.sidgs.odp.api.service;

import com.sidgs.odp.api.error.OrgException;
import com.sidgs.odp.model.Org;

/**
 * Created by kalya on 6/26/2017.
 */
public interface OrgService {

    // Saving new Organization
    void saveOrganizaion(Org org) throws Exception;

    //make an Org Active

    void enableOrg(String orgName) throws OrgException;

    //diasable org

    void disableOrg(Org org);

}

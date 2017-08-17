package com.sidgs.odp.api.controllers;

//import com.sidgs.odp.model.Org;
import com.sidgs.odp.api.service.OrgService;
import com.sidgs.odp.model.Organization;
import com.sidgs.odp.repository.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by ayeluri on 8/13/2017.
 */
@RestController
@RequestMapping("org")
public class OrgController {
    @Autowired
    private OrgService orgService;

    @RequestMapping (method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Organization> getOrgs(){
        return orgService.getAll();
    }
    
    @RequestMapping (method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void add(Organization org)  {
        try {
            orgService.saveOrganizaion(org);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package com.sidgs.odp;


import com.sidgs.odp.api.error.UserLoginException;
import com.sidgs.odp.api.service.UserInfoService;
import com.sidgs.odp.error.BaseException;
import com.sidgs.odp.model.*;
import com.sidgs.odp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalya on 5/11/2017.
 */
@SpringBootApplication
@RestController
@RequestMapping("api")
public class ApiApp {

    @Autowired
    UserInfoService userInfoService;

    public static void main(String[] args) {
        SpringApplication.run(ApiApp.class,args);
    }


    //trial************trial
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(method = RequestMethod.POST, path = "/authenticate",
//            consumes = MediaType.APPLICATION_JSON_VALUE
//            )
//    public  String auth (@RequestBody @Valid AuthenticateInfoUI userentereddetails) throws BaseException, UserLoginException {
//
//        return userentereddetails.getEmail();
//
//    }

    @RequestMapping(path= "test/roles" , method = RequestMethod.GET)
    public List<Role> getRoleInfoSample() {


        List<Role> roles = new ArrayList<Role>();

        Role role1 = new Role( "Scrum Master", "");
        Role role2 = new Role( "Team Manager", "");
        Role role3 = new Role( "Group Manager", "");


        roles.add(role1);

        roles.add(role2);

        roles.add(role3);

        return roles ;
    }

    @RequestMapping(path= "test/areasOfInterest" , method = RequestMethod.GET)
    public List<Role> getAreasOfIntrestSample() {


        List<Role> roles = new ArrayList<Role>();

        Role role1 = new Role( "Scrum Master", "");
        Role role2 = new Role( "Team Manager", "");
        Role role3 = new Role( "Group Manager", "");

        //scrum master kpis for ODP
            for (String areaOfinterest : ("ODP,MyFavCard,MyAccount,MySavings," +
                    "HomeLoansPA, HomeLoansNJ").split(","))
                role1.addAreaOfInterest(
                        new AreaOfInterest(areaOfinterest, areaOfinterest));

        //team manager
            for (String areaOfinterest : ("DevOps-t1, Devops-t2,Banking-1,Banking-2," +
                    "Leading-1, Lending-2,Fraud-1, Fraud-2").split(","))
                role2.addAreaOfInterest(
                        new AreaOfInterest(areaOfinterest, areaOfinterest));

        // Group Manager
            for (String areaOfinterest : "DevOps,Banking,Leading,Fraud".split(","))
                role3.addAreaOfInterest(
                        new AreaOfInterest(areaOfinterest, areaOfinterest));


        roles.add(role1);

        roles.add(role2);

        roles.add(role3);

        return roles ;
    }


    @RequestMapping(path= "test/kpi-list" , method = RequestMethod.GET)
    public List<KPIRoleAoIMapping> getKPIRoleAoIMapping() {

        List<KPIRoleAoIMapping> kpiRoleAoIMappings= new ArrayList<KPIRoleAoIMapping>();

        Role role1 = new Role( "Scrum Master", "");
        Role role2 = new Role( "Team Manager", "");
        Role role3 = new Role( "Group Manager", "");

        AreaOfInterest areaOfInterest1 = new AreaOfInterest("ODP" , "ODP");

        //scrum master kpis for ODP
        for ( String kpi : "jira,build,scm".split(",")) {
            for (String areaOfinterest : ("ODP,MyFavCard,MyAccount,MySavings," +
                    "HomeLoansPA, HomeLoansNJ").split(","))
            kpiRoleAoIMappings.add(new KPIRoleAoIMapping(role1,
                    new AreaOfInterest(areaOfinterest, areaOfinterest),
                    new KPI("project-"+kpi)));
        }

        // Team manager KPI
        for ( String kpi : "projects,build,scm,financials".split(",")) {
            for (String areaOfinterest : ("DevOps-t1, Devops-t2,Banking-1,Banking-2," +
                    "Leading-1, Lending-2,Fraud-1, Fraud-2").split(","))
            kpiRoleAoIMappings.add(new KPIRoleAoIMapping(role2, new AreaOfInterest(areaOfinterest, areaOfinterest),
                    new KPI("team-"+kpi)));
        }

        // Group Manager
        for ( String kpi : "projects,build,scm,financials".split(",")) {
            for (String areaOfinterest : "DevOps,Banking,Leading,Fraud".split(","))
                kpiRoleAoIMappings.add(new KPIRoleAoIMapping(role3,
                        new AreaOfInterest(areaOfinterest, areaOfinterest),
                        new KPI("group-"+kpi)));
        }

        return  kpiRoleAoIMappings ;
    }


}
package com.sidgs.odp.api.controllers;

import com.sidgs.odp.api.error.RoleException;
import com.sidgs.odp.api.service.RoleService;
import com.sidgs.odp.model.Role;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kalyan on 5/9/2017.
 */

@RestController
@RequestMapping("api/role")
public class RoleController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(RoleController.class);
    private RoleService roleService;


    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addRole(@RequestBody Role role){
        log.info("");
        try {
            roleService.saveRole(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ExceptionHandler (RoleException.class)
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleRoleException(RequestBody requestBody, ResponseBody responseBody, Exception exception ) {


    }

   /* @RequestMapping(method=RequestMethod.DELETE)
    public void deleteRole(@RequestBody Role role) throws RoleException{
         log.info("Deleting a role");
        if(role!=null) {
            try {
                roleService.deleteRole(role);
            }catch(Exception e){
                log.error("Error Ocurred unable to delete a role"+ role.getName(), e);

                throw new RoleException("unable to delete role" + role.getName());
            }

        }else{
            log.info("the Role object is empty");
        }
    } */



    public void activateRole(){

    }


    public void deactivateRole(){

    }


    public void updateRole(){

    }


    }




package com.sidgs.odp.api.service;
import com.sidgs.odp.api.error.ActivateRoleException;
import com.sidgs.odp.api.error.RoleException;
import com.sidgs.odp.model.Role;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by kalyan on 5/9/2017.
 */

public interface RoleService {
    // to save a new to database
    void saveRole(Role role) throws RoleException;



    // to update a existing role
    void updateRole(Role role) throws RoleException;

    // to activate a existing Role

    void activateRole(Role role) throws RoleException, ActivateRoleException;

    //to deactivate a active existing role
    void deactivateRole(Role role) throws RoleException, ActivateRoleException;


    // to return all the roles
    Collection<Role> getRoles() throws RoleException;


}

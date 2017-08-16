package com.sidgs.odp.api.service;

import com.sidgs.odp.api.error.ActivateRoleException;
import com.sidgs.odp.api.error.RoleException;
import com.sidgs.odp.model.Role;
import com.sidgs.odp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kalya on 5/9/2017.
 */
@Service

public class RoleServiceImpl implements RoleService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RoleServiceImpl.class);

    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveRole(Role role) throws RoleException {

        if(role != null && role.getName()!=null) {
            log.info("saving new role");
            try {
                roleRepository.save(role);
            }catch(Exception e){
                log.error("unable to save new role"+role.getName(),e);
                throw new RoleException(e);
            }
        }else{
            log.error("role object is null");
        }
    }



    @Override
    public void updateRole(Role role)  throws RoleException {
        if(role!=null){
            if(role.getName()!=null){
                log.info("Updating the Role");
                try{
                    roleRepository.delete(role.getName());
                    roleRepository.save(role);
                }catch(Exception e){
                    log.error("Exception Occured in Updating role ",role.getName());
                    throw new RoleException(e);
                }
            }else{
                throw new RoleException("Role Name is required");
            }

        }else{
            log.error("role object is null");
        }
    }

    @Override
    public void activateRole(Role role) throws RoleException, ActivateRoleException {
        if(role!=null){
            if(role.getName()!=null){
                if(role.isStatus()!= true){
                    try{
                        role.setStatus(true);
                        roleService.updateRole(role);

                    }catch(Exception e){
                        log.error("unable to activate role"+role.getName());
                        throw new RoleException(e);
                    }
                }else{
                    throw new ActivateRoleException(role.getName()+"is in Active Status");
                }

            }else{
                throw new RoleException("Role name is required");
            }

        }else{
            log.error("role object is null");
        }

    }

    @Override
    public void deactivateRole(Role role) throws RoleException, ActivateRoleException {
        if(role!=null){
            if(role.getName()!=null){
                if(role.isStatus()!= false){
                    try{
                        role.setStatus(false);
                        roleService.updateRole(role);

                    }catch(Exception e){
                        log.error("unable to deactivate role"+role.getName());
                        throw new RoleException(e);
                    }
                }else{
                    throw new ActivateRoleException(role.getName()+"is not Active, Deactivation not required");
                }

            }else{
                throw new RoleException("Role name is required");
            }

        }else{
            log.error("role object is null");
        }

    }

    @Override
    public Collection<Role> getRoles() throws RoleException{
        try {
            List<Role> list = (List<Role>) roleRepository.findAll();
            Set<Role> set = new HashSet<Role>(list);
            return set;
        }catch(Exception e){
            throw new RoleException("",e);
        }

    }
}

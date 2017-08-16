package com.sidgs.odp.api.service;

import com.sidgs.odp.api.error.AreaOfInterestException;
import com.sidgs.odp.model.AreaOfInterest;
import com.sidgs.odp.model.Role;
import com.sidgs.odp.repository.RoleRepository;
import com.sidgs.odp.repository.AreaOfInterestRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saimanu.manoj on 10-05-2017.
 */
@Component
public class AreaOfInterestServiceImpl implements AreaOfInterestService {

    Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    AreaOfInterestRepository areaOfInterestRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override

    public void addAreaOfInterest(AreaOfInterest areaOfInterest) throws AreaOfInterestException {

        try {
            logger.info("trying to save areaofinterest object from repo to service");
            areaOfInterestRepository.save(areaOfInterest);
        }
        catch (Exception e){
            logger.error("error occred in AreaOfInterestServiceImpl while saving area of interest object"
                    +areaOfInterest.getName() , e);
           throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while Adding " +
                   "Area Of Interest"+areaOfInterest.getName());
        }
    }

    @Override
    public void updateAreaOfInterest(AreaOfInterest areaOfInterest) throws AreaOfInterestException {

        if(areaOfInterest != null) {
            try {
// If you delete all relationships are lost .. that is not what a update should do
//                areaOfInterestRepository.delete(areaOfInterest);
                areaOfInterestRepository.save(areaOfInterest);
            } catch (Exception e) {
                logger.error("error occred in AreaOfInterestServiceImpl while updating area of interest object"
                        + areaOfInterest.getName(), e);
                throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while updating " +
                        "Area Of Interest"+areaOfInterest.getName());
            }
        }
        else{
            logger.error("object is null");
        }

    }

    @Override
    public List<AreaOfInterest> getAllAreaOfInterest() throws AreaOfInterestException {

        List<AreaOfInterest> areaOfInterestList = new ArrayList<AreaOfInterest>();
        try {
            areaOfInterestList = (List<AreaOfInterest>) areaOfInterestRepository.findAll();
        }
        catch (Exception e){
            logger.error("error occred in AreaOfInterestServiceImpl while retrving list of " +
                    "area of interest objects" , e);
            throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while fetching list of " +
                    "Area Of Interest");
        }
        return areaOfInterestList;
    }


    @Override
    public void activateAreaOfInterest(AreaOfInterest areaOfInterest) throws AreaOfInterestException {

        if (areaOfInterest != null) {
            try {

                if (areaOfInterest.isStatus() == false) {

                    areaOfInterest.setStatus(true);
                    areaOfInterestRepository.save(areaOfInterest);
                }
            }
            catch (Exception e) {

                logger.error("error occred in AreaOfInterestServiceImpl while activating area of interest " +
                        "object" + areaOfInterest.getName(), e);
                throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while Activating " +
                        "Area Of Interest"+areaOfInterest.getName());
            }
        }

    }

    @Override
    public void deactiveAreaOfInterest(AreaOfInterest areaOfInterest) throws AreaOfInterestException {

        if(areaOfInterest != null) {
            try {

                if (areaOfInterest.isStatus() == true) {
                    areaOfInterest.setStatus(false);
                    areaOfInterestRepository.save(areaOfInterest);
                }



            } catch (Exception e) {
                logger.error("error occred in AreaOfInterestServiceImpl while deactivating area of interest " +
                        "object" + areaOfInterest.getName(), e);
                throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while De-activating " +
                        "Area Of Interest"+areaOfInterest.getName());
            }
        }
    }

    @Override
    public void associateToRole(Role role, AreaOfInterest areaOfInterest) throws AreaOfInterestException {
        // get the  Role from Mongo based in Role Name
        Role rol = roleRepository.findOne(role.getName());

        if (StringUtils.isEmpty(areaOfInterest.getName())) throw new AreaOfInterestException("", "Name cannot be empty");
        else
        areaOfInterest = areaOfInterestRepository.findOne(areaOfInterest.getName());

        rol.addAreaOfInterest(areaOfInterest);

        roleRepository.save(rol);
    }

    @Override
    public void deassociateFromRole(Role role, AreaOfInterest areaOfInterest) throws AreaOfInterestException {
        //TODO implement this
        if(role !=null && areaOfInterest !=null){
            try{
                Role rol = roleRepository.findOne(role.getName());
                if(rol.getAreaOfInterestList().contains(areaOfInterest)){
                    int i = rol.getAreaOfInterestList().indexOf(areaOfInterest);
                    rol.getAreaOfInterestList().remove(i);
                }
                else{
                    logger.error("Area of interest object entered is not found ");
                }
            }
            catch (Exception e){
                logger.error("Error occured while deasscoating AreaOfInterest Object "
                        +areaOfInterest.getName() +"from role " +role.getName());
            }
        }

        else{
            logger.error("Either role or areaOfInterest object are null");
        }

    }

    /*  @Override
    public void associateToRole(Role role, AreaOfInterest areaOfInterest) throws AreaOfInterestException {
        try {
            logger.info("associating "+areaOfInterest+"to"+ role.getName()+"....");
            if (role != null && areaOfInterest != null) {
                List<AreaOfInterest> areaOfInterestList = role.getAreaOfInterestList();
                areaOfInterestList.add(areaOfInterest);
                logger.info("added to list of areaofinterest successful");
            }
        }
        catch(Exception e){
            logger.error("error occured while associating "+role.getName()+"to area of interest object"
                    +areaOfInterest.getName(),e);
        }
    }

    @Override
    public void deassociateFromRole(Role role , AreaOfInterest areaOfInterest) throws AreaOfInterestException {

        try {
            logger.info("deassociating "+areaOfInterest+"to"+ role.getName()+"....");
            if (role != null && areaOfInterest != null) {
                List<AreaOfInterest> areaOfInterestList = role.getAreaOfInterestList();
                areaOfInterestList.remove(areaOfInterest);
                logger.info("removed from list of areaofinterest successful");
            }
        }
        catch (Exception e){
            logger.error("error occured while deassociating "+role.getName()+"to area of interest object"
                    +areaOfInterest.getName(),e);
        }

    } */


   /* @Override
    public void associateRoleToAreaOFInterest(Role role,AreaOfInterest areaOfInterest) throws AreaOfInterestException {

        try {
            if (areaOfInterest.getRole() == null) {
                areaOfInterest.setRole(role);
            }
        }
        catch(Exception e){
            logger.error("error occured while associating "+role.getName()+"to area of interest object"
                    +areaOfInterest.getName(),e);
        }
    }

    @Override
    public void deassociateRoleFromAreaOFInterest(Role role,AreaOfInterest areaOfInterest) throws AreaOfInterestException {

        try {
            logger.info("deassociating role"+role.getName()+"from area");
            if (areaOfInterest.getRole() != null) {
                if(role.getName().equals(areaOfInterest.getRole().getName())){
                    areaOfInterest.setRole(null);
                }
                else{
                    logger.error("role name "+role+"doesn't match with exsisting role name " +
                            areaOfInterest.getRole().getName());
                }

            }
        }
        catch(Exception e){
            logger.error("error occured while deassociating "+role.getName()+"to area of interest object"
                    +areaOfInterest.getName(),e);
        }
    } */
}

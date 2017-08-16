package com.sidgs.odp.api.controllers;

import com.sidgs.odp.api.error.AreaOfInterestException;
import com.sidgs.odp.api.service.AreaOfInterestService;
import com.sidgs.odp.model.AreaOfInterest;
import com.sidgs.odp.model.Role;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saimanu.manoj on 10-05-2017.
 */

@RestController
@RequestMapping("aoi")
public class AreaOfIntrestController {
    @Autowired
   private AreaOfInterestService areaOfInterestService;

    Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping(method= RequestMethod.POST)
    public void addBusinessDomain(AreaOfInterest areaOfInterest) throws AreaOfInterestException{

     logger.info("adding areaofInterest" +areaOfInterest.getName());
     try {
      areaOfInterestService.addAreaOfInterest(areaOfInterest);
      logger.info("Added successfully" +areaOfInterest.getName());
     } catch (AreaOfInterestException e) {
      logger.error("Exception thrown while adding areaOfInterest" +areaOfInterest.getName(),e);
      throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while saving Area of " +
              "Interest "+areaOfInterest.getName());
     }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateBusinessDomain(AreaOfInterest areaOfInterest) throws AreaOfInterestException{

     try {
      logger.info("trying to update Area of interest" +areaOfInterest.getName());
      areaOfInterestService.updateAreaOfInterest(areaOfInterest);
      logger.info("areaOfInterest successfully updated" +areaOfInterest.getName());
     } catch (AreaOfInterestException e) {
      logger.error("Error occured while updating areOfInterest " +areaOfInterest.getName(),e);
      throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while saving Area of " +
              "Interest "+areaOfInterest.getName());

     }
    }

    @RequestMapping("list")
    public List<AreaOfInterest> getAllAreaOfInterest() throws AreaOfInterestException{

     List<AreaOfInterest> areaOfInterests=new ArrayList<AreaOfInterest>();

     try {
      logger.info("trying to get list of area of interest avaliable");
     areaOfInterests= areaOfInterestService.getAllAreaOfInterest();
      logger.info("fetching list of area of interest successful");
     } catch (AreaOfInterestException e) {
      logger.error("Error occured while getting list of areaof interests" ,e);
      throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while fetching list of " +
              "Area Of Interest" );
     }
     return areaOfInterests;
    }

    @RequestMapping(path= "activate", method=RequestMethod.PUT)
    public void activateBusinessDomain(AreaOfInterest areaOfInterest) throws AreaOfInterestException{

     try{
      areaOfInterestService.activateAreaOfInterest(areaOfInterest);
     }
     catch(AreaOfInterestException e){
      logger.error("Error occured while activating area of interest"+areaOfInterest.getName(),e);
      throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while Activating Area of " +
              "Interest "+areaOfInterest.getName());
     }


    }

    @RequestMapping(path= "deactivate" , method = RequestMethod.PUT )
    public void deactivateBusinessDomain(AreaOfInterest areaOfInterest) throws AreaOfInterestException{

     try {
      areaOfInterestService.deactiveAreaOfInterest(areaOfInterest);
     } catch (AreaOfInterestException e) {
      logger.error("Error occured while deactivating area of interest"+areaOfInterest.getName(),e);
      throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while De-activating Area of " +
              "Interest "+areaOfInterest.getName());
     }

    }

    @RequestMapping(path= "associate" , method = RequestMethod.PUT)
     public void associateToRole(Role role, AreaOfInterest areaOfInterest) throws AreaOfInterestException{

     try {
      logger.info("associating role"+role.getName()+ "to"+areaOfInterest.getName()+".....");
      areaOfInterestService.associateToRole(role, areaOfInterest);
      logger.info("associating role successful");
     }
     catch (AreaOfInterestException e){
      logger.error("error occured while associating "+role.getName()+"to area of interest object"
              +areaOfInterest.getName()
              +"in the area of intrsert controller",e);
      throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while Associating  Area of " +
              "Interest "+areaOfInterest.getName()+" to role  "+role.getName());
     }
    }

    @RequestMapping(path= "deassociate" , method = RequestMethod.PUT)
    public void deassociateToRole(Role role , AreaOfInterest areaOfInterest) throws AreaOfInterestException {

     try {
      logger.info("deassociating role"+role.getName()+ "to"+areaOfInterest.getName()+".....");
      areaOfInterestService.deassociateFromRole(role, areaOfInterest);
      logger.info("deassociating role successful");
     }
     catch(AreaOfInterestException e){
      logger.error("error occured while deassociating "+role.getName()+"to area of interest object"
              +areaOfInterest.getName()
              +"in the area of intrsert controller",e);
      throw new AreaOfInterestException(e,"HTTP_500","Internal Server Error Occured while De-associating Area of " +
              "Interest "+areaOfInterest.getName()+" to role "+role.getName());
     }
    }


}

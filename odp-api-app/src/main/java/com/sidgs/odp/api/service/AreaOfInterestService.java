package com.sidgs.odp.api.service;

import com.sidgs.odp.api.error.AreaOfInterestException;
import com.sidgs.odp.model.AreaOfInterest;
import com.sidgs.odp.model.Role;

import java.util.List;

/**
 * Created by saimanu.manoj on 10-05-2017.
 */
public interface AreaOfInterestService {

    public void addAreaOfInterest(AreaOfInterest areaOfInterest) throws AreaOfInterestException;

    public void updateAreaOfInterest(AreaOfInterest areaOfInterest) throws AreaOfInterestException;

    public void activateAreaOfInterest(AreaOfInterest areaOfInterest) throws AreaOfInterestException;

    public void deactiveAreaOfInterest(AreaOfInterest areaOfInterest) throws AreaOfInterestException;

    public List<AreaOfInterest> getAllAreaOfInterest() throws AreaOfInterestException;

   public void associateToRole(Role role , AreaOfInterest areaOfInterest) throws AreaOfInterestException;

    public void deassociateFromRole(Role role , AreaOfInterest areaOfInterest) throws AreaOfInterestException;

//    public void associateRole(Role role,AreaOfInterest areaOfInterest) throws AreaOfInterestException;

//    public void deassociateRole(Role role,AreaOfInterest areaOfInterest) throws AreaOfInterestException;


}

package com.sidgs.odp.api.service;

import com.sidgs.odp.model.KPI;
import com.sidgs.odp.api.error.KPIException;

import java.util.List;

/**
 * Created by srika on 5/10/2017.
 */
public interface KPIService  {

    public void addKPI(KPI kpi) throws KPIException;

    public void updateKPI(KPI kpi) throws KPIException;

    public void activateKPI(KPI kpi) throws KPIException;

    public void deactivateKPI(KPI kpi) throws KPIException;



    public List<KPI> getAllKPIs() throws KPIException;


}

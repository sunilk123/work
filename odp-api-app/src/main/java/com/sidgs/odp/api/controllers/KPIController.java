package com.sidgs.odp.api.controllers;

import com.sidgs.odp.model.KPI;
import com.sidgs.odp.api.error.KPIException;
import com.sidgs.odp.api.service.KPIService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by srika on 5/10/2017.
 */

@RestController
@RequestMapping("kpi")
public class KPIController {



    @Autowired
    private KPIService kpiService;

    Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping(method = RequestMethod.POST)
    public void addKPI(@RequestBody KPI kpi) throws KPIException{

        logger.info("adding KPI" + kpi.getName());
        try {
            kpiService.addKPI(kpi);
            logger.info("Successfully added the KPI" + kpi.getName());
        } catch (KPIException e) {
            logger.error("Error while adding the KPI" + kpi.getName(),e);
            throw new KPIException(e,"HTTP_500","Internal Server Error occured while adding KPI"+kpi.getName());
        }

    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateKPI(@RequestBody KPI kpi) throws KPIException{

        logger.info("Updating the KPI" +kpi.getName());
        try {
            kpiService.updateKPI(kpi);
            logger.info("Successfully updated the KPI" +kpi.getName());
        } catch (KPIException e) {
            logger.error("Error while updating the KPI" +kpi.getName(),e);
            throw new KPIException(e,"HTTP_500","Internal Server Error occured while updating KPI"+kpi.getName());
        }

    }


    @RequestMapping("/list")
    public List<KPI> getAllKPIs() throws KPIException {

        List kpis = new ArrayList<KPI>();

        logger.info("Fetching list of KPIs available");
        try {
            kpis = kpiService.getAllKPIs();
            logger.info("Successfully fetched the list of KPIs available");

        } catch (KPIException e) {
            logger.error("Error occurred while fetching the list of KPIs",e);
            throw new KPIException(e,"HTTP_500","Internal Server Error occurred while fetching the list of KPIs");
        }

        return kpis;
    }
}

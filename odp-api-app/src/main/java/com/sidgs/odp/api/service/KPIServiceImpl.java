package com.sidgs.odp.api.service;

import com.sidgs.odp.api.error.KPIException;
import com.sidgs.odp.model.KPI;
import com.sidgs.odp.repository.KPIRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

@Service
public class KPIServiceImpl implements KPIService {


    @Autowired
    KPIRepository kpiRepository;

    Log logger = LogFactory.getLog(this.getClass());

    @Override
    public void addKPI(KPI kpi) throws KPIException {

        try {
            logger.info("trying to save KPI");
            kpiRepository.save(kpi);
        }
        catch (Exception e){
            logger.error("error occurred in while saving KPI object"
                    +kpi.getName() , e);
            throw new KPIException(e,"HTTP_500","Internal Server Error Occured while Adding KPI "+kpi.getName());
        }
    }


    @Override
    public void updateKPI(KPI kpi) throws KPIException {

        if(kpi != null) {
            try {

                if( kpi.getName()!=null && getKpi(kpi.getName())!=null) {
                    logger.info("Updating the KPI"+kpi.getName());
                    KPI kpi1 = getKpi(kpi.getName());
                    kpi1.setDescription(kpi.getDescription());
                    kpi1.setStatus(kpi.isStatus());
                    kpiRepository.save(kpi1);
                }

                else {
                    throw new KPIException("HTTP_500","Internal Server Error Occurred while updating KPI"+kpi.getName());
                }
            } catch (Exception e) {
                logger.error("error occurred in while updating area of interest object"+ kpi.getName(), e);
                throw new KPIException(e,"HTTP_500","Internal Server Error Occurred while updating KPI"+kpi.getName());
            }
        }
        else{
            logger.error("object is null");
        }

    }

    @Override
    public void activateKPI(KPI kpi) throws KPIException {

        if (kpi != null && getKpi(kpi.getName())!= null) {
            try {

                kpi = getKpi(kpi.getName());
                if (kpi.isStatus() == false) {

                    kpi.setStatus(true);

                }

                kpiRepository.save(kpi);
            }
            catch (Exception e) {

                logger.error("error occurred while activating KPI" + kpi.getName(), e);
                throw new KPIException(e,"HTTP_500","Internal Server Error occurred while activating KPI"+kpi.getName());
            }
        }
        else {
            // KPI was not found ; the KPI is invalid
            throw new KPIException("HTTP_500","KPI is not valid : "+kpi.getName());
        }

    }

    @Override
    public void deactivateKPI(KPI kpi) throws KPIException {
        if(kpi != null &&  getKpi(kpi.getName())!= null ) {
            try {

                kpi = getKpi(kpi.getName());
                if (kpi.isStatus() == true) {
                    kpi.setStatus(false);
                }

                kpiRepository.save(kpi);

            } catch (Exception e) {
                logger.error("error occurred while deactivating KPI" + kpi.getName(), e);
                throw new KPIException(e,"HTTP_500","Internal Server Error occurred while deactivating KPI"+kpi.getName());
            }
        } else {
            // KPI was not found ; the KPI is invalid
            throw new KPIException("HTTP_500","KPI is not valid : "+kpi.getName());
        }

    }


    @Override
    public List<KPI> getAllKPIs() throws KPIException {

        List<KPI> kpis = new ArrayList<KPI>();
        try {
            kpis = (List<KPI>) kpiRepository.findAll();
        }
        catch (Exception e){
            logger.error("error occurred in while retrieving list of KPIs" ,e);
            throw new KPIException(e,"HTTP_500","Internal Server Error occurred while fetching the list of KPIs");
        }
        return kpis;
    }

    private KPI getKpi(String name ) {
        return kpiRepository.findOne(name);
    }
}

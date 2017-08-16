package com.sidgs.odp.api.service;

import com.sidgs.odp.api.error.ConnectorException;
import com.sidgs.odp.model.Connector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryarakaraju on 7/8/17.
 */
@Service
public class ConnectorServiceImpl implements ConnectorService {

    Log logger = LogFactory.getLog(this.getClass());

    MongoRepository mongoRepository;

    @Override
    public void addConnector(Connector connector) throws ConnectorException {
        try {
            logger.info("trying to save connector object from repo to service");
            mongoRepository.save(connector);
        }
        catch (Exception e){
            logger.error("error occred in ConnectorServiceImpl while saving connector object"
                    +connector.getConnectorName() , e);
            throw new ConnectorException(e,"HTTP_500","Internal Server Error Occured while Adding " +
                    "Connector"+connector.getConnectorName());
        }

    }

    @Override
    public void updateConnector(Connector connector) throws ConnectorException {


        if(connector != null) {
            try {
                mongoRepository.save(connector);
            } catch (Exception e) {
                logger.error("error occred while updating area of connector object"
                        + connector.getConnectorName(), e);
                throw new ConnectorException(e,"HTTP_500","Internal Server Error Occured while updating " +
                        "Connector"+connector.getConnectorName());
            }
        }
        else{
            logger.error("object is null");
        }

    }

    @Override
    public List<Connector> getAllConnectors() throws ConnectorException {
        List<Connector> connectorList = new ArrayList<Connector>();
        try {
            connectorList = (List<Connector>) mongoRepository.findAll();
        }
        catch (Exception e){
            logger.error("error occred  while retrving list of " +
                    "connector objects" , e);
            throw new ConnectorException(e,"HTTP_500","Internal Server Error Occured while fetching list of " +
                    "Connector");
        }
        return connectorList;
    }
}

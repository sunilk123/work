package com.sidgs.odp.api.controllers;

import com.sidgs.odp.api.error.ConnectorException;
import com.sidgs.odp.api.service.ConnectorService;
import com.sidgs.odp.model.Connector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ryarakaraju on 2/8/17.
 */
@RestController
@RequestMapping("/connector")
public class ConnectorController {
    @Autowired
    private ConnectorService connectorService;
    Log logger = LogFactory.getLog(this.getClass());
    Connector connector = new Connector();

    @RequestMapping(path = "/add", method= RequestMethod.POST)
    public void addConnector(Connector connector) throws ConnectorException {

        try {
            connectorService.addConnector(connector);
            logger.info("Connector added successfully");
        } catch (Exception e) {
            logger.error("error occured while saving connector "
                    +connector.getConnectorName(),e);
            throw new ConnectorException(e,"HTTP_500","Internal Server Error occured while " +
                    "saving area of interest object");
        }


    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public void updateConnector(Connector connector) throws ConnectorException{

        try {
            logger.info("Updating connector object "+connector.getConnectorName()+" ...");
            connectorService.updateConnector(connector);
            logger.info("Successfully updated");
        } catch (Exception e) {
            logger.error("error occured while updating connector object with " +
                    "name "+connector.getConnectorName()+" ....");
            throw new ConnectorException(e,"HTTP_500","Internal Server Occured " +
                    "while updating Connector Object" +connector.getConnectorName());
        }

    }
}


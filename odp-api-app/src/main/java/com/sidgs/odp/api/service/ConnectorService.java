package com.sidgs.odp.api.service;

import com.sidgs.odp.api.error.ConnectorException;
import com.sidgs.odp.model.Connector;

import java.util.List;

/**
 * Created by ryarakaraju on 7/8/17.
 */
public interface ConnectorService {

    public void addConnector(Connector connector) throws ConnectorException;

    public void updateConnector(Connector connector) throws ConnectorException;

    public List<Connector> getAllConnectors() throws ConnectorException;

}

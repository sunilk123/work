package com.sidgs.odp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document (collection = "odp-org")

public class  Organization {

    @Id
    @NotNull(message="Organization name cannot be null")
    String nameOfOrg;

    String orgStatus;
    String domainName ;
    String orgOwnerName ;
    Date dateCreated ;
    Date dataUpdated ;
    String orgOwnerEmail ;


    public Organization(String nameOfOrg) {
        this.nameOfOrg = nameOfOrg;
    }

    public String getNameOfOrg() {
        return nameOfOrg;
    }

    public void setNameOfOrg(String nameOfOrg) {
        this.nameOfOrg = nameOfOrg;
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getOrgOwnerName() {
        return orgOwnerName;
    }

    public void setOrgOwnerName(String orgOwnerName) {
        this.orgOwnerName = orgOwnerName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDataUpdated() {
        return dataUpdated;
    }

    public void setDataUpdated(Date dataUpdated) {
        this.dataUpdated = dataUpdated;
    }

    public String getOrgOwnerEmail() {
        return orgOwnerEmail;
    }

    public void setOrgOwnerEmail(String orgOwnerEmail) {
        this.orgOwnerEmail = orgOwnerEmail;
    }

    @Override
    public int hashCode() {
        return nameOfOrg.hashCode();
    }
}

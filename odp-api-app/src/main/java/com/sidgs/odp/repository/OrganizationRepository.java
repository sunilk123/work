package com.sidgs.odp.repository;

import com.sidgs.odp.model.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by rohit on 8/16/2017.
 */
public interface OrganizationRepository extends MongoRepository<Organization,String>{
}

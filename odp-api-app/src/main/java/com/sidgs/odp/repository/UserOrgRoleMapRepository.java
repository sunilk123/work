package com.sidgs.odp.repository;

import com.sidgs.odp.model.UserOrgRoleMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by SUNIL PC on 16-08-2017.
 */
public interface UserOrgRoleMapRepository extends MongoRepository<UserOrgRoleMapping,String> {
}

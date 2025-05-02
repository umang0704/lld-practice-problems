package com.lld_interview.spring_tempalte.feature_tenants.repo;

import com.lld_interview.spring_tempalte.feature_tenants.entities.Tenants;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Tenant repository.
 */
@Repository
public interface TenantRepository extends MongoRepository<Tenants,String> {
}

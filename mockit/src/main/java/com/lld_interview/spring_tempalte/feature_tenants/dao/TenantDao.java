package com.lld_interview.spring_tempalte.feature_tenants.dao;

import com.lld_interview.spring_tempalte.feature_tenants.entities.Tenants;
import com.lld_interview.spring_tempalte.feature_tenants.repo.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * The type Tenant dao.
 */
@Component
public class TenantDao {
    private final TenantRepository tenantRepository;

    /**
     * Instantiates a new Tenant dao.
     *
     * @param tenantRepository the tenant repository
     */
    @Autowired
    public TenantDao(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    /**
     * Save tenants.
     *
     * @param tenant the tenant
     * @return the tenants
     */
    public Tenants save(Tenants tenant){
        return tenantRepository.save(tenant);
    }

    /**
     * Get by id optional.
     *
     * @param tenantId the tenant id
     * @return the optional
     */
    public Optional<Tenants> getById(String tenantId){
        return tenantRepository.findById(tenantId);
    }
}

package com.lld_interview.spring_tempalte.feature_tenants.services;

import com.lld_interview.spring_tempalte.feature_tenants.models.request.CreateTenantRequest;
import com.lld_interview.spring_tempalte.feature_tenants.models.response.CreateTenantResponse;

/**
 * The interface Tenant service.
 */
public interface TenantService {

    /**
     * Create tenant create tenant response.
     *
     * @param createTenantRequest the create tenant request
     * @return the create tenant response
     */
    CreateTenantResponse createTenant(CreateTenantRequest createTenantRequest);

}

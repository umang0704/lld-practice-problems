package com.lld_interview.spring_tempalte.feature_tenants.services.impl;

import com.lld_interview.spring_tempalte.feature_tenants.dao.TenantDao;
import com.lld_interview.spring_tempalte.feature_tenants.models.request.CreateTenantRequest;
import com.lld_interview.spring_tempalte.feature_tenants.models.response.CreateTenantResponse;
import com.lld_interview.spring_tempalte.feature_tenants.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantServiceImpl implements TenantService {
    private final TenantDao tenantDao;

    @Autowired
    public TenantServiceImpl(TenantDao tenantDao) {
        this.tenantDao = tenantDao;
    }

    @Override
    public CreateTenantResponse createTenant(CreateTenantRequest createTenantRequest) {
//        tenantDao.findB
        return null;
    }
}

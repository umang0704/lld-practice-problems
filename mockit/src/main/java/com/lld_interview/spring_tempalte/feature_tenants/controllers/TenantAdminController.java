package com.lld_interview.spring_tempalte.feature_tenants.controllers;

import com.lld_interview.spring_tempalte.feature_tenants.models.request.CreateTenantRequest;
import com.lld_interview.spring_tempalte.models.response.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin/v1/api/tenants")
public class TenantAdminController {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize(value = "hasAuthority('admin:tenant:create')")
    public ResponseEntity<BaseResponse> createTenant(
            @RequestBody @Valid CreateTenantRequest createTenantRequest
            ){
        BaseResponse response = new BaseResponse();
        return ResponseEntity.ok(response);
    }
}

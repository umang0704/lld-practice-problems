package com.lld_interview.spring_tempalte.feature_tenants.models.response;

import com.lld_interview.spring_tempalte.feature_tenants.models.TenantSecret;
import lombok.Data;

@Data
public class CreateTenantResponse {
    private String id;
    private String name;
    private String email;
    private String secretKey;
    private String apiKey;
}

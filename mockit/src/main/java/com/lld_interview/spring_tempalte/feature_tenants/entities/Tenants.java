package com.lld_interview.spring_tempalte.feature_tenants.entities;

import com.lld_interview.spring_tempalte.feature_api_mock.entities.DateAudit;
import com.lld_interview.spring_tempalte.feature_tenants.models.TenantSecret;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Tenants extends DateAudit {
    @Id
    private String id;
    private String name;
    private String email;
    private List<TenantSecret> tenantSecrets;
    private List<String> whitelistedIps;
}

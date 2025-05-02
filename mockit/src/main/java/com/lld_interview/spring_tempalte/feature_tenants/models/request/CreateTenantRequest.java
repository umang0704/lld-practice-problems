package com.lld_interview.spring_tempalte.feature_tenants.models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTenantRequest {
    @NotBlank(message = "Field name should be present.")
    private String name;
    @NotBlank(message = "Field email should be present.")
    private String email;
    @NotEmpty(message = "Field whiteListedIps should be present.")
    private List<String> whitelistedIps;
}

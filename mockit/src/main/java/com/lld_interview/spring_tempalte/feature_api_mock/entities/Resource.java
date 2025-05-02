package com.lld_interview.spring_tempalte.feature_api_mock.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lld_interview.spring_tempalte.feature_api_mock.enums.RestVerb;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.MediaType;

@Document
@Data
public class Resource extends DateAudit{
    @Id
    private String id;
    private String tenantId;
    private String refId;
    private String apiPath;
    private RestVerb verb;
    private MediaType consumes;
    private MediaType produces;
}

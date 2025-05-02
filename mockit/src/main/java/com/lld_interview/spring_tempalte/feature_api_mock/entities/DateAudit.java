package com.lld_interview.spring_tempalte.feature_api_mock.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
public class DateAudit {
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}

package com.lld_interview.spring_tempalte.models.response;

import lombok.Data;

@Data
public class BaseResponse {
    private String responseCode;
    private String message;
    private Object data;
}

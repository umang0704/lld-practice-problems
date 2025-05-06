package com.lld_interview.id_test.models;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String email;
}

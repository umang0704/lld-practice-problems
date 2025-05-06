package com.lld_interview.id_test.service;

import com.lld_interview.id_test.models.CreateUserRequest;
import com.lld_interview.id_test.models.CreateUserResponse;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Create user long create user response.
     *
     * @param request the request
     * @return the create user response
     */
    CreateUserResponse createUserLong(CreateUserRequest request);
}

package com.lld_interview.id_test.controllers;

import com.lld_interview.id_test.models.CreateUserRequest;
import com.lld_interview.id_test.models.CreateUserResponse;
import com.lld_interview.id_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 */
@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create user long response entity.
     *
     * @param createUserRequest the create user request
     * @return the response entity
     */
    @PostMapping(
            path = "/long",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CreateUserResponse> createUserLong(
            @RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.ok(userService.createUserLong(createUserRequest));
    }
}

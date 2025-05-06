package com.lld_interview.id_test.service.impl;

import com.lld_interview.id_test.dao.UserDao;
import com.lld_interview.id_test.entities.UserLong;
import com.lld_interview.id_test.models.CreateUserRequest;
import com.lld_interview.id_test.models.CreateUserResponse;
import com.lld_interview.id_test.repo.UserLongRepo;
import com.lld_interview.id_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public CreateUserResponse createUserLong(CreateUserRequest request) {
        UserLong userLong = new UserLong();
        userLong.setEmai(request.getEmail());
        userLong.setName(request.getName());
        userLong = userDao.saveUser(userLong);

        return new CreateUserResponse(
                userLong.getId().toString());
    }
}

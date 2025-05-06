package com.lld_interview.id_test.dao;

import com.lld_interview.id_test.entities.UserLong;
import com.lld_interview.id_test.repo.UserLongRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User dao.
 */
@Component
@RequiredArgsConstructor
public class UserDao {
    private final UserLongRepo userLongRepo;

    /**
     * Save user user long.
     *
     * @param userLong the user long
     * @return the user long
     */
    public UserLong saveUser(UserLong userLong){
        return userLongRepo.save(userLong);
    }
}

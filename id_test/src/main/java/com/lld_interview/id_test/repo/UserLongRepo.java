package com.lld_interview.id_test.repo;

import com.lld_interview.id_test.entities.UserLong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface User long repo.
 */
@Repository
public interface UserLongRepo extends JpaRepository<UserLong,Long> {
}

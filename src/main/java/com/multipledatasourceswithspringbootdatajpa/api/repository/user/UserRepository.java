package com.multipledatasourceswithspringbootdatajpa.api.repository.user;

import com.multipledatasourceswithspringbootdatajpa.api.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

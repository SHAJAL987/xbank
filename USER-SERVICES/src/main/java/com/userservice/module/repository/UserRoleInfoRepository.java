package com.userservice.module.repository;

import com.userservice.module.model.UserRoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleInfoRepository extends JpaRepository<UserRoleInfo,Long> {
    Optional<UserRoleInfo> findById(Long id);
}

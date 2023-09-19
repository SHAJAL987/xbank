package com.userservice.module.repository;

import com.userservice.module.model.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleInfoRepository extends JpaRepository<RoleInfo,Long> {
    Optional<RoleInfo> findById(Long id);
}

package com.userservice.module.repository;

import com.userservice.module.model.RoleFeatureInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleFeatureInfoRepository extends JpaRepository<RoleFeatureInfo,Long> {
    @Override
    Optional<RoleFeatureInfo> findById(Long id);
}

package com.userservice.module.repository;

import com.userservice.module.model.FeatureInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureInfoRepository extends JpaRepository<FeatureInfo,Long> {
    Optional<FeatureInfo> findById(Long id);
}

package com.userservice.module.service;

import com.userservice.module.payload.RoleFeatureInfoDto;

import java.util.List;

public interface RoleFeatureInfoService {
    public RoleFeatureInfoDto createRoleFeature(RoleFeatureInfoDto roleFeatureInfoDto);
    public RoleFeatureInfoDto getRoleFeature(Long id);
    public List<RoleFeatureInfoDto> getAllRoleFeature();
    void deleteRoleFeature(Long id);
}

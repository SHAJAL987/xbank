package com.userservice.module.service;

import com.userservice.module.payload.RoleInfoDto;

import java.util.List;

public interface RoleInfoService {
    RoleInfoDto saveRole (RoleInfoDto roleInfoDto);
    RoleInfoDto getRoleInfoById(Long id);
    RoleInfoDto updateRole(RoleInfoDto roleInfoDto, Long id);
    List<RoleInfoDto> getAllRoleInfo();
    void deleteRoleInfo(Long id);
    RoleInfoDto approveRole(RoleInfoDto roleInfoDto, Long id);
}

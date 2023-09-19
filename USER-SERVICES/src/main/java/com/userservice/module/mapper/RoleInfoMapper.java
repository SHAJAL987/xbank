package com.userservice.module.mapper;

import com.userservice.module.model.RoleInfo;
import com.userservice.module.payload.RoleInfoDto;

public class RoleInfoMapper {
    public static RoleInfoDto mapToRoleInfoDto(RoleInfo roleInfo){
        RoleInfoDto roleInfoDto = new RoleInfoDto();
        roleInfoDto.setId(roleInfo.getId());
        roleInfoDto.setRoleName(roleInfo.getRoleName());
        roleInfoDto.setRoleShortCode(roleInfo.getRoleShortCode());
        roleInfoDto.setStatus(roleInfo.isStatus());
        roleInfoDto.setCreateBy(roleInfo.getCreateBy());
        roleInfoDto.setCreateDate(roleInfo.getCreateDate());
        roleInfoDto.setApprovedBy(roleInfo.getApprovedBy());
        roleInfoDto.setApprovedDate(roleInfo.getApprovedDate());

        return roleInfoDto;
    }

    public static RoleInfo mapToRoleInfo(RoleInfoDto roleInfoDto){
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleName(roleInfoDto.getRoleName());
        roleInfo.setRoleShortCode(roleInfoDto.getRoleShortCode());
        roleInfo.setStatus(roleInfoDto.isStatus());
        roleInfo.setCreateBy(roleInfoDto.getCreateBy());
        return roleInfo;
    }
}

package com.userservice.module.mapper;

import com.userservice.module.model.RoleFeatureInfo;
import com.userservice.module.payload.RoleFeatureInfoDto;

public class RoleFeatureInfoMapper {
    public static RoleFeatureInfoDto mapToRoleFeatureInfoDto(RoleFeatureInfo roleFeatureInfo){
        RoleFeatureInfoDto roleFeatureInfoDto = new RoleFeatureInfoDto();
        roleFeatureInfoDto.setId(roleFeatureInfo.getId());
        roleFeatureInfoDto.setFeatureId(roleFeatureInfo.getFeatureId());
        roleFeatureInfoDto.setRoleId(roleFeatureInfo.getRoleId());
        roleFeatureInfoDto.setCreateBy(roleFeatureInfo.getCreateBy());
        roleFeatureInfoDto.setCreateDate(roleFeatureInfo.getCreateDate());

        return roleFeatureInfoDto;
    }

    public static RoleFeatureInfo mapToRoleFeatureInfo(RoleFeatureInfoDto roleFeatureInfoDto){
        RoleFeatureInfo roleFeatureInfo = new RoleFeatureInfo();
        roleFeatureInfo.setFeatureId(roleFeatureInfoDto.getFeatureId());
        roleFeatureInfo.setRoleId(roleFeatureInfoDto.getRoleId());
        roleFeatureInfo.setCreateBy(roleFeatureInfoDto.getCreateBy());

        return roleFeatureInfo;
    }
}

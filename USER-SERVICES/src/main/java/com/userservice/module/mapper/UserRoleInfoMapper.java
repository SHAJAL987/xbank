package com.userservice.module.mapper;

import com.userservice.module.model.UserRoleInfo;
import com.userservice.module.payload.UserRoleInfoDto;

public class UserRoleInfoMapper {
    public static UserRoleInfoDto mapToUserRoleInfoDto(UserRoleInfo userRoleInfo){
        UserRoleInfoDto userRoleInfoDto = new UserRoleInfoDto();
        userRoleInfoDto.setRoleId(userRoleInfo.getRoleId());
        userRoleInfoDto.setUserId(userRoleInfo.getUserId());
        userRoleInfoDto.setRoleId(userRoleInfo.getRoleId());
        userRoleInfoDto.setCreateBy(userRoleInfo.getCreateBy());
        userRoleInfoDto.setCreateDate(userRoleInfo.getCreateDate());
        return userRoleInfoDto;
    }
    public static UserRoleInfo mapToUserRole(UserRoleInfoDto userRoleInfoDto){
        UserRoleInfo userRoleInfo = new UserRoleInfo();
        userRoleInfo.setUserId(userRoleInfoDto.getUserId());
        userRoleInfo.setRoleId(userRoleInfoDto.getRoleId());
        userRoleInfo.setCreateBy(userRoleInfoDto.getCreateBy());
        return userRoleInfo;
    }
}

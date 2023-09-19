package com.userservice.module.service;

import com.userservice.module.model.UserRoleInfo;
import com.userservice.module.payload.UserRoleInfoDto;

import java.util.List;

public interface UserRoleInfoService {
    UserRoleInfoDto saveUserRoleInfo(UserRoleInfoDto userRoleInfoDto);
    public UserRoleInfoDto getUserRoleInfoById(Long id);
    public UserRoleInfoDto updateUserRoleInfo(UserRoleInfoDto userRoleInfoDto,Long id);
    List<UserRoleInfoDto> getAllUserRoleInfo();
    public void deleteUserRoleInfo(Long id);

}


package com.userservice.module.service;

import com.userservice.module.payload.UserInfoDto;

import java.util.List;

public interface UserInfoService {
    UserInfoDto saveUserInfo(UserInfoDto userInfoDto);
    UserInfoDto getUserInfoByUserCode(String userCode);
    List<UserInfoDto> getAllUserInfo();
    UserInfoDto updateUserInfo(UserInfoDto userInfoDto, String userCode);
    void deleteUser(String userCode);
}

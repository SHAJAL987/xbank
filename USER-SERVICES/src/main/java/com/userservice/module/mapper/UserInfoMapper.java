package com.userservice.module.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userservice.module.model.UserInfo;
import com.userservice.module.payload.UserInfoDto;
import com.userservice.module.utils.PasswordHashingWithSalting;

public class UserInfoMapper {

    public static UserInfoDto mapToUserInfoDto(UserInfo userInfo){
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUserCode(userInfo.getUserCode());
        userInfoDto.setUserName(userInfo.getUserName());
        userInfoDto.setUserEmail(userInfo.getUserEmail());
        userInfoDto.setUserPhone(userInfo.getUserPhone());
        userInfoDto.setUserStatus(userInfo.isUserStatus());
        userInfoDto.setUserType(userInfo.getUserType());
        userInfoDto.setCreateBy(userInfo.getCreateBy());
        userInfoDto.setCreateDate(userInfo.getCreateDate());
        userInfoDto.setApprovedBy(userInfo.getApprovedBy());
        userInfoDto.setApprovedDate(userInfo.getApprovedDate());

        return userInfoDto;
    }

    public static UserInfo mapToUserInfo(UserInfoDto userInfoDto){
        PasswordHashingWithSalting passwordHashingWithSalting = new PasswordHashingWithSalting();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserCode(userInfoDto.getUserCode());
        userInfo.setUserName(userInfoDto.getUserName());
        userInfo.setUserEmail(userInfoDto.getUserEmail());
        userInfo.setUserPhone(userInfoDto.getUserPhone());
        userInfo.setUserPass(passwordHashingWithSalting.hashPassword(userInfoDto.getUserPass()));
        userInfo.setUserStatus(userInfoDto.isUserStatus());
        userInfo.setUserType(userInfoDto.getUserType());
        userInfo.setCreateBy(userInfoDto.getCreateBy());
        userInfo.setApprovedBy(userInfoDto.getApprovedBy());

        return userInfo;
    }

}

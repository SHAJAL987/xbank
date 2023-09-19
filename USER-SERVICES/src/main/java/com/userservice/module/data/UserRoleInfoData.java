package com.userservice.module.data;

import com.userservice.module.model.UserRoleInfo;
import com.userservice.module.payload.UserRoleInfoDto;
import lombok.Data;

import java.util.List;

@Data
public class UserRoleInfoData {
    List<UserRoleInfoDto> userRoleInfolist;
}

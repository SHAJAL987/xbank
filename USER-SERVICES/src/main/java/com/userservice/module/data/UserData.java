package com.userservice.module.data;

import com.userservice.module.payload.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class UserData {
    List<UserInfoDto> userList;
}

package com.userservice.module.data;

import com.userservice.module.payload.RoleInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleInfoData {
    List<RoleInfoDto> roleInfoList;
}

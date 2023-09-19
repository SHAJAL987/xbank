package com.userservice.module.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleInfoDto {
    private Long id;
    @NotNull(message = "User Id must not be Empty.")
    private int userId;
    @NotNull(message = "Role Id must not be Empty.")
    private int roleId;
    @NotEmpty(message = "Create by must not be Empty.")
    private String createBy;
    private Date createDate;
}

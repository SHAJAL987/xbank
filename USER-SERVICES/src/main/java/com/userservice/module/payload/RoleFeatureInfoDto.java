package com.userservice.module.payload;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleFeatureInfoDto {
    private Long id;
    @NotNull(message = "Role id cannot be empty.")
    private int roleId;
    @NotNull(message = "Feature id cannot be empty.")
    private int featureId;
    @NotEmpty(message = "Create user cannot be empty.")
    private String createBy;
    private Date createDate;
}

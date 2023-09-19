package com.userservice.module.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfoDto {
    private Long id;
    @NotEmpty(message = "Role name cannot be empty.")
    @Size(min = 3,max = 50, message = "Role name cannot be bigger then 50 Char.")
    private String roleName;
    @NotEmpty(message = "Role short code cannot be empty.")
    @Size(max = 3, message = "Role short code cannot be bigger then 3 char.")
    private String roleShortCode;
    private boolean status;
    @NotEmpty(message = "Create by cannot be empty.")
    private String createBy;
    private Date createDate;
    private String approvedBy;
    private LocalDateTime approvedDate;
}

package com.userservice.module.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
    @NotEmpty(message = "User code cannot be empty.")
    @Min(value = 4, message = "Minimum length of user code is 4 char.")
    private String userCode;
    @NotEmpty(message = "User code cannot be empty.")
    private String userName;
    @NotEmpty(message = "Email Id cannot be empty.")
    @Email(message = "Provide valid email address.")
    private String userEmail;
    @NotEmpty(message = "User phone number cannot be empty.")
    //@Pattern(regexp = "^(\\\\+?01)[3-9][0-9]{8}$", message = "Provide valid mobile number")
    private String userPhone;
    @NotEmpty(message = "User password cannot be empty.")
    //@Pattern(regexp = "^(?=.*[!@#$%^&*(),.?\\\":{}|<>])(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$", message = "Minimum one digit, one char, one special char and Min length 8 required.")
    private String userPass;
    private boolean userStatus;
    @NotEmpty(message = "User Type Cannot be empty.")
    private String userType;
    @NotEmpty(message = "Create by cannot be empty.")
    private String createBy;
    private Date createDate;
    private String approvedBy;
    private Date approvedDate;
}

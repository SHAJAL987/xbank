package com.userservice.module.payload;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureInfoDto {
    private Long id;
    @NotEmpty(message = "Feature name cannot be empty.")
    @Size(min = 3,max = 50, message = "Feature name cannot be bigger then 50 Char.")
    private String featureName;
    private Long parentFeatureId;
    @NotEmpty(message = "Parent or Child field cannot be empty.")
    private String parentOrChild;
    @NotNull(message = "Level cannot be empty.")
    private int level;
    @NotEmpty(message = "Feature url cannot be empty.")
    private String url;
    private boolean isRoot;
    @NotEmpty(message = "Run user cannot be empty.")
    private String createBy;
    private Date createDate;
}

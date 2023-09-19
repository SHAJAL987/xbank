package com.userservice.module.data;

import com.userservice.module.model.RoleFeatureInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleFeatureInfoData {
    List<RoleFeatureInfo> roleFeatureInfoData;
}

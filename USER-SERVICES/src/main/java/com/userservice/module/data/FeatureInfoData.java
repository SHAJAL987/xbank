package com.userservice.module.data;

import com.userservice.module.payload.FeatureInfoDto;
import lombok.Data;

import java.util.List;

@Data
public class FeatureInfoData {
    List<FeatureInfoDto> featureInfoList;
}

package com.userservice.module.mapper;

import com.userservice.module.model.FeatureInfo;
import com.userservice.module.payload.FeatureInfoDto;

public class FeatureInfoMapper {
    public static FeatureInfoDto mapToFeatureDto(FeatureInfo featureInfo){
        FeatureInfoDto featureInfoDto = new FeatureInfoDto();
        featureInfoDto.setId(featureInfo.getId());
        featureInfoDto.setFeatureName(featureInfo.getFeatureName());
        featureInfoDto.setParentFeatureId(featureInfo.getParentFeatureId());
        featureInfoDto.setLevel(featureInfo.getLevel());
        featureInfoDto.setParentOrChild(featureInfo.getParentOrChild());
        featureInfoDto.setUrl(featureInfo.getUrl());
        featureInfoDto.setRoot(featureInfo.isRoot());
        featureInfoDto.setCreateBy(featureInfo.getCreateBy());
        featureInfoDto.setCreateDate(featureInfo.getCreateDate());

        return featureInfoDto;
    }

    public static FeatureInfo mapToFeatureInfo(FeatureInfoDto featureInfoDto){
        FeatureInfo featureInfo = new FeatureInfo();
        featureInfo.setFeatureName(featureInfoDto.getFeatureName());
        featureInfo.setParentFeatureId(featureInfoDto.getParentFeatureId());
        featureInfo.setLevel(featureInfoDto.getLevel());
        featureInfo.setUrl(featureInfoDto.getUrl());
        featureInfo.setRoot(featureInfoDto.isRoot());
        featureInfo.setParentOrChild(featureInfoDto.getParentOrChild());
        featureInfo.setCreateBy(featureInfoDto.getCreateBy());

        return featureInfo;
    }
}

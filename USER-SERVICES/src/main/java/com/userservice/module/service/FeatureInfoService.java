package com.userservice.module.service;

import com.userservice.module.model.FeatureInfo;
import com.userservice.module.payload.FeatureInfoDto;
import lombok.extern.java.Log;

import java.util.List;

public interface FeatureInfoService {
    public FeatureInfoDto saveFeature(FeatureInfoDto featureInfoDto);
    public List<FeatureInfoDto> getAllFeature();
    public FeatureInfoDto getFeatureById(Long id);
    void deleteFeatureInfo(Long id);
}

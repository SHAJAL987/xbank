package com.userservice.module.serviceImpl;

import com.userservice.module.exception.ResourceNotFoundException;
import com.userservice.module.mapper.FeatureInfoMapper;
import com.userservice.module.model.FeatureInfo;
import com.userservice.module.payload.FeatureInfoDto;
import com.userservice.module.repository.FeatureInfoRepository;
import com.userservice.module.service.FeatureInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureInfoServiceImpl implements FeatureInfoService {
    private FeatureInfoRepository featureInfoRepository;

    public FeatureInfoServiceImpl(FeatureInfoRepository featureInfoRepository) {
        this.featureInfoRepository = featureInfoRepository;
    }

    @Override
    public FeatureInfoDto saveFeature(FeatureInfoDto featureInfoDto) {
        FeatureInfo featureInfoRes = FeatureInfoMapper.mapToFeatureInfo(featureInfoDto);
        FeatureInfo saveFeatureInfo = featureInfoRepository.save(featureInfoRes);
        FeatureInfoDto resSaveFeatureRes = FeatureInfoMapper.mapToFeatureDto(saveFeatureInfo);
        return resSaveFeatureRes;
    }

    @Override
    public List<FeatureInfoDto> getAllFeature() {
        List<FeatureInfo> featureInfos = featureInfoRepository.findAll();
        return featureInfos.stream().map(featureInfo -> FeatureInfoMapper.mapToFeatureDto(featureInfo)).collect(Collectors.toList());
    }

    @Override
    public FeatureInfoDto getFeatureById(Long id) {
        FeatureInfo featureInfo = featureInfoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("FeatureInfo","id",id.toString())
        );
        FeatureInfoDto featureInfoDto = FeatureInfoMapper.mapToFeatureDto(featureInfo);
        return featureInfoDto;
    }

    @Override
    public void deleteFeatureInfo(Long id) {
        FeatureInfo featureInfo = featureInfoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("FeatureInfo","id",id.toString())
        );
        featureInfoRepository.delete(featureInfo);
    }
}

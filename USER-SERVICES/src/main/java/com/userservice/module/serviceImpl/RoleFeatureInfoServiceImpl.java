package com.userservice.module.serviceImpl;

import com.userservice.module.exception.ResourceNotFoundException;
import com.userservice.module.mapper.FeatureInfoMapper;
import com.userservice.module.mapper.RoleFeatureInfoMapper;
import com.userservice.module.mapper.RoleInfoMapper;
import com.userservice.module.model.FeatureInfo;
import com.userservice.module.model.RoleFeatureInfo;
import com.userservice.module.model.RoleInfo;
import com.userservice.module.payload.RoleFeatureInfoDto;
import com.userservice.module.repository.FeatureInfoRepository;
import com.userservice.module.repository.RoleFeatureInfoRepository;
import com.userservice.module.repository.RoleInfoRepository;
import com.userservice.module.service.RoleFeatureInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleFeatureInfoServiceImpl implements RoleFeatureInfoService {

    private RoleFeatureInfoRepository roleFeatureInfoRepository;
    private RoleInfoRepository roleInfoRepository;
    private FeatureInfoRepository featureInfoRepository;

    public RoleFeatureInfoServiceImpl(RoleFeatureInfoRepository roleFeatureInfoRepository) {
        this.roleFeatureInfoRepository = roleFeatureInfoRepository;
    }

    @Override
    public RoleFeatureInfoDto createRoleFeature(RoleFeatureInfoDto roleFeatureInfoDto) {

        Long featureId = Long.valueOf(roleFeatureInfoDto.getFeatureId());
        Long roleId = Long.valueOf(roleFeatureInfoDto.getRoleId());

//        FeatureInfo featureInfo = featureInfoRepository.findById(featureId).orElseThrow(
//                ()-> new ResourceNotFoundException("Feature Info","id",featureId.toString())
//        );
//        RoleInfo roleInfo = roleInfoRepository.findById(roleId).orElseThrow(
//                ()-> new ResourceNotFoundException("Role Info","id",roleId.toString())
//        );

        RoleFeatureInfo roleFeatureInfo = RoleFeatureInfoMapper.mapToRoleFeatureInfo(roleFeatureInfoDto);
        RoleFeatureInfo saveRoleFeatureInfo = roleFeatureInfoRepository.save(roleFeatureInfo);
        return RoleFeatureInfoMapper.mapToRoleFeatureInfoDto(saveRoleFeatureInfo);
    }

    @Override
    public RoleFeatureInfoDto getRoleFeature(Long id) {
        RoleFeatureInfo roleFeatureInfo = roleFeatureInfoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Role Feature Info","id",id.toString())
        );
        RoleFeatureInfoDto roleFeatureInfoDto = RoleFeatureInfoMapper.mapToRoleFeatureInfoDto(roleFeatureInfo);
        return roleFeatureInfoDto;
    }

    @Override
    public List<RoleFeatureInfoDto> getAllRoleFeature() {
        List<RoleFeatureInfo> roleFeatureInfoDtoResponse = roleFeatureInfoRepository.findAll();
        System.out.println(roleFeatureInfoDtoResponse.toString());
        return roleFeatureInfoDtoResponse.stream().map(roleFeatureInfo -> RoleFeatureInfoMapper.mapToRoleFeatureInfoDto(roleFeatureInfo)).collect(Collectors.toList());
    }

    @Override
    public void deleteRoleFeature(Long id) {
        RoleFeatureInfo roleFeatureInfo = roleFeatureInfoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Role Feature Id","id",id.toString())
        );
        roleFeatureInfoRepository.delete(roleFeatureInfo);
    }


}

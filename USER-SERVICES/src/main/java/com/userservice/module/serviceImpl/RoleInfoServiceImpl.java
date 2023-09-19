package com.userservice.module.serviceImpl;

import com.userservice.module.exception.ResourceNotFoundException;
import com.userservice.module.exception.UserAlreadyExistsException;
import com.userservice.module.mapper.RoleInfoMapper;
import com.userservice.module.mapper.UserInfoMapper;
import com.userservice.module.model.RoleInfo;
import com.userservice.module.model.UserInfo;
import com.userservice.module.payload.RoleInfoDto;
import com.userservice.module.repository.RoleInfoRepository;
import com.userservice.module.service.RoleInfoService;
import com.userservice.module.utils.GlobalItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    private RoleInfoRepository roleInfoRepository;

    public RoleInfoServiceImpl(RoleInfoRepository roleInfoRepository) {
        this.roleInfoRepository = roleInfoRepository;
    }

    @Override
    public RoleInfoDto saveRole(RoleInfoDto roleInfoDto) {
            RoleInfo roleInfo = RoleInfoMapper.mapToRoleInfo(roleInfoDto);
            RoleInfo saveRoleInfo = roleInfoRepository.save(roleInfo);
            RoleInfoDto roleInfoDtoResponse = RoleInfoMapper.mapToRoleInfoDto(saveRoleInfo);
            return roleInfoDtoResponse;
    }

    @Override
    public RoleInfoDto getRoleInfoById(Long id) {
        RoleInfo roleInfo = roleInfoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("RoleInfo","Id",id.toString())
        );
        return RoleInfoMapper.mapToRoleInfoDto(roleInfo);
    }

    @Override
    public RoleInfoDto updateRole(RoleInfoDto roleInfoDto, Long id) {
        RoleInfo roleInfo = roleInfoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Role Info","Id",id.toString())
        );
        roleInfo.setRoleName(roleInfoDto.getRoleName());
        roleInfo.setRoleShortCode(roleInfoDto.getRoleShortCode());

        RoleInfo roleInfoRes = roleInfoRepository.save(roleInfo);

        return RoleInfoMapper.mapToRoleInfoDto(roleInfoRes);
    }

    @Override
    public List<RoleInfoDto> getAllRoleInfo() {
        List<RoleInfo> roleInfos = roleInfoRepository.findAll();
        return roleInfos.stream().map(roleInfo->RoleInfoMapper.mapToRoleInfoDto(roleInfo)).collect(Collectors.toList());
    }

    @Override
    public void deleteRoleInfo(Long id) {
        RoleInfo roleInfo = roleInfoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("RoleInfo","id",id.toString())
        );
        roleInfoRepository.delete(roleInfo);
    }

    @Override
    public RoleInfoDto approveRole(RoleInfoDto roleInfoDto, Long id) {
        RoleInfo roleInfo = roleInfoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Role Info","id",id.toString())
        );
        roleInfo.setApprovedBy(roleInfoDto.getApprovedBy());
        roleInfo.setApprovedDate(LocalDateTime.now());

        RoleInfo roleInfoRes = roleInfoRepository.save(roleInfo);

        return RoleInfoMapper.mapToRoleInfoDto(roleInfoRes);
    }
}

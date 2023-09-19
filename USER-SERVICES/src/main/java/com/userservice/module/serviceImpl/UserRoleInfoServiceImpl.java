package com.userservice.module.serviceImpl;

import com.userservice.module.exception.ResourceNotFoundException;
import com.userservice.module.mapper.UserRoleInfoMapper;
import com.userservice.module.model.UserRoleInfo;
import com.userservice.module.payload.UserRoleInfoDto;
import com.userservice.module.repository.UserRoleInfoRepository;
import com.userservice.module.service.UserRoleInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleInfoServiceImpl implements UserRoleInfoService {

    private UserRoleInfoRepository userRoleInfoRepository;

    public UserRoleInfoServiceImpl(UserRoleInfoRepository userRoleInfoRepository) {
        this.userRoleInfoRepository = userRoleInfoRepository;
    }

    @Override
    public UserRoleInfoDto saveUserRoleInfo(UserRoleInfoDto userRoleInfoDto) {
        UserRoleInfo userRoleInfo = UserRoleInfoMapper.mapToUserRole(userRoleInfoDto);
        UserRoleInfo saveUserRoleInfo = userRoleInfoRepository.save(userRoleInfo);
        UserRoleInfoDto userRoleInfoDtoRes = UserRoleInfoMapper.mapToUserRoleInfoDto(saveUserRoleInfo);
        return userRoleInfoDtoRes;
    }

    @Override
    public UserRoleInfoDto getUserRoleInfoById(Long id) {
        UserRoleInfo userRoleInfo = userRoleInfoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("UserRoleInfo","Id",id.toString())
        );
        return UserRoleInfoMapper.mapToUserRoleInfoDto(userRoleInfo);
    }

    @Override
    public UserRoleInfoDto updateUserRoleInfo(UserRoleInfoDto userRoleInfoDto, Long id) {
        UserRoleInfo userRoleInfo = userRoleInfoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("UserRoleInfo","Id",id.toString())
        );
        userRoleInfo.setRoleId(userRoleInfo.getRoleId());
        userRoleInfo.setUserId(userRoleInfo.getUserId());
        userRoleInfo.setCreateBy(userRoleInfo.getCreateBy());
        return UserRoleInfoMapper.mapToUserRoleInfoDto(userRoleInfo);
    }

    @Override
    public List<UserRoleInfoDto> getAllUserRoleInfo() {
        List<UserRoleInfo> userRoleInfos = userRoleInfoRepository.findAll();
        return userRoleInfos.stream().map(
                userRoleInfo -> UserRoleInfoMapper.mapToUserRoleInfoDto(userRoleInfo)
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteUserRoleInfo(Long id) {
        UserRoleInfo userRoleInfo = userRoleInfoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("UserRoleInfo","Id",id.toString())
        );
        userRoleInfoRepository.delete(userRoleInfo);
    }


}

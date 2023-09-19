package com.userservice.module.serviceImpl;

import com.userservice.module.exception.ResourceNotFoundException;
import com.userservice.module.exception.UserAlreadyExistsException;
import com.userservice.module.mapper.UserInfoMapper;
import com.userservice.module.model.UserInfo;
import com.userservice.module.payload.UserInfoDto;
import com.userservice.module.repository.UserInfoRepository;
import com.userservice.module.service.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserInfoDto saveUserInfo(UserInfoDto userInfoDto) {

        Optional<UserInfo> findByUserCode = userInfoRepository.findByUserCode(userInfoDto.getUserCode());

        if (findByUserCode.isPresent()){
            throw new UserAlreadyExistsException("User already exist for user.");
        }else {
            //convert userInfoDto to UserInfo
            UserInfo saveUser = UserInfoMapper.mapToUserInfo(userInfoDto);

            //Data Save Into Database
            UserInfo saveUserJpa = userInfoRepository.save(saveUser);

            //convert userInfo to UserDto
            UserInfoDto userInfoResponse = UserInfoMapper.mapToUserInfoDto(saveUserJpa);
            return userInfoResponse;
        }
    }

    @Override
    public UserInfoDto getUserInfoByUserCode(String userCode) {
        UserInfo userInfo = userInfoRepository.findByUserCode(userCode).orElseThrow(
                ()->new ResourceNotFoundException("UserInfo","UserCode",userCode)
        );
        return UserInfoMapper.mapToUserInfoDto(userInfo);
    }

    @Override
    public List<UserInfoDto> getAllUserInfo() {
        List<UserInfo> userInfos = userInfoRepository.findAll();
        return userInfos.stream().map(userInfo -> UserInfoMapper.mapToUserInfoDto(userInfo)).collect(Collectors.toList());
    }

    @Override
    public UserInfoDto updateUserInfo(UserInfoDto userInfoDto, String userCode) {
        UserInfo userInfo = userInfoRepository.findByUserCode(userCode).orElseThrow(
                ()->new ResourceNotFoundException("UserInfo","UserCode",userCode)
        );
        userInfo.setUserName(userInfoDto.getUserName());
        userInfo.setUserStatus(userInfoDto.isUserStatus());
        userInfo.setUserEmail(userInfoDto.getUserEmail());
        userInfo.setUserPhone(userInfoDto.getUserPhone());
        userInfo.setUserType(userInfoDto.getUserType());
        userInfo.setApprovedBy(userInfoDto.getApprovedBy());

        UserInfo update = userInfoRepository.save(userInfo);

        UserInfoDto userUpdateResponse = UserInfoMapper.mapToUserInfoDto(update);

        return userUpdateResponse;
    }

    @Override
    public void deleteUser(String userCode) {
        UserInfo userInfo = userInfoRepository.findByUserCode(userCode).orElseThrow(
                ()->new ResourceNotFoundException("UserInfo","UserCode",userCode)
        );
        userInfoRepository.delete(userInfo);
    }

}

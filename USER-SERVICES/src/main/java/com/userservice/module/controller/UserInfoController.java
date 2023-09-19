package com.userservice.module.controller;

import com.userservice.module.data.UserData;
import com.userservice.module.payload.UserInfoDto;
import com.userservice.module.response.ResponseHandler;
import com.userservice.module.service.UserInfoService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/u/v1")
public class UserInfoController {
    private UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    //************* Create User ***************
    //Url: http://localhost:8080/user/u/v1/createUser
    @PostMapping(value = "/createUser")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserInfoDto userInfoDto){
        UserInfoDto saveUser = userInfoService.saveUserInfo(userInfoDto);
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("userInfo",saveUser);
        return ResponseHandler.responseBuilder("Operation Successful","100",userInfo);
    }

    //************ Get user by userCode ********
    //Url: http://localhost:8080/user/u/v1/<userCode>
    @GetMapping("/{userCode}")
    public ResponseEntity<Object> getUserByUserCode(@PathVariable("userCode") Long userCode){
        UserInfoDto userInfoDto = userInfoService.getUserInfoByUserCode(Long.toString(userCode));
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("userInfo",userInfoDto);
        return ResponseHandler.responseBuilder("Operation Successful","100",userInfo);
    }

    //********* Get All user ************
    //Url: http://localhost:8080/user/u/v1/findAllUser
    @GetMapping("/findAllUser")
    public ResponseEntity<Object> getAllUser(){
        List<UserInfoDto> users = userInfoService.getAllUserInfo();
        UserData userList = new UserData();
        userList.setUserList(users);
        return ResponseHandler.responseBuilder("Operation Successful","100",userList);
    }

    //********** Update User by User Code **************
    //Url: http://localhost:8080/user/u/v1/<userCode>
    @PutMapping("/{userCode}")
    public ResponseEntity<Object> updateByUserCode(@Valid @RequestBody UserInfoDto userInfoDto,
                                                   @PathVariable("userCode") Long userCode){
        UserInfoDto userUpdate = userInfoService.updateUserInfo(userInfoDto,Long.toString(userCode));
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("userInfo",userUpdate);
        return ResponseHandler.responseBuilder("Operation Successful","100",userInfo);
    }

    //********** Delete User By User Code ***************
    //Url: http://localhost:8080/user/u/v1/<userCode>
    @DeleteMapping("/{userCode}")
    public ResponseEntity<Object> deleteUserByUserCode(@PathVariable("userCode") Long userCode){
        userInfoService.deleteUser(Long.toString(userCode));
        Map<String,Object> deletedInfo = new HashMap<>();
        deletedInfo.put("deletedUserCode",Long.toString(userCode));
        deletedInfo.put("resMsg","User Deleted Successful");
        return ResponseHandler.responseBuilder("Operation Successful","100",deletedInfo);
    }


}

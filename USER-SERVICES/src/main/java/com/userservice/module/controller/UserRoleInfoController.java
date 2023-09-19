package com.userservice.module.controller;

import com.userservice.module.data.UserRoleInfoData;
import com.userservice.module.payload.UserRoleInfoDto;
import com.userservice.module.response.ResponseHandler;
import com.userservice.module.service.UserRoleInfoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/ur/v1")
public class UserRoleInfoController {
    private UserRoleInfoService userRoleInfoService;

    public UserRoleInfoController(UserRoleInfoService userRoleInfoService) {
        this.userRoleInfoService = userRoleInfoService;
    }

    //**************** Create User Role ***************************
    //Url: http://localhost:8181/user/ur/v1/createUserRole
    @PostMapping("/createUserRole")
    public ResponseEntity<Object> createUserRole(@Valid @RequestBody UserRoleInfoDto userRoleInfoDto){
        UserRoleInfoDto userRoleInfoDtoRes = userRoleInfoService.saveUserRoleInfo(userRoleInfoDto);
        Map<String,Object> userRoleInfoData = new HashMap<>();
        userRoleInfoData.put("userRoleInfoData",userRoleInfoDtoRes);
        return ResponseHandler.responseBuilder("Operation Successful","100",userRoleInfoData);
    }

    // ***************** Get User Role By Id *****************
    //Url: http://localhost:8181/user/ur/v1/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserRoleById(@PathVariable("id") Long id){
        UserRoleInfoDto userRoleInfoDto = userRoleInfoService.getUserRoleInfoById(id);
        Map<String,Object> userRoleInfoData = new HashMap<>();
        userRoleInfoData.put("userRoleInfoData",userRoleInfoDto);
        return ResponseHandler.responseBuilder("Operation Successful","100",userRoleInfoData);
    }

    //**************** Update User Role ***********************
    //Url: http://localhost:8181/user/ur/v1/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserRoleById(@RequestBody UserRoleInfoDto userRoleInfoDto, @PathVariable("id") Long id){
        UserRoleInfoDto userRoleInfoDtoRes = userRoleInfoService.updateUserRoleInfo(userRoleInfoDto,id);
        Map<String,Object> userRoleInfoData = new HashMap<>();
        userRoleInfoData.put("userRoleInfoData",userRoleInfoDtoRes);
        return ResponseHandler.responseBuilder("Operation Successful","100",userRoleInfoData);
    }

    //**************** Get All User Role Info ****************
    //Url: http://localhost:8181/user/ur/v1/findAll
    @GetMapping("/findAll")
    public ResponseEntity<Object> getAllUserRoleInfo(){
        List<UserRoleInfoDto> userRoleInfoDtoList = userRoleInfoService.getAllUserRoleInfo();
        UserRoleInfoData userRoleInfoData = new UserRoleInfoData();
        userRoleInfoData.setUserRoleInfolist(userRoleInfoDtoList);
        return ResponseHandler.responseBuilder("Operation Successful","100",userRoleInfoData);
    }

    //************** Delete User Role Info ********************
    //Url: http://localhost:8181/user/ur/v1/deleteById
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserRoleInfo(@PathVariable("id") Long id){
        userRoleInfoService.deleteUserRoleInfo(id);
        Map<String,Object> userRoleInfoData = new HashMap<>();
        userRoleInfoData.put("deletedUserRoleInfoId",id.toString());
        userRoleInfoData.put("resMsg","User role info deleted successful.");
        return ResponseHandler.responseBuilder("Operation Successful","100",userRoleInfoData);
    }



}

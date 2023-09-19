package com.userservice.module.controller;

import com.userservice.module.payload.RoleFeatureInfoDto;
import com.userservice.module.response.ResponseHandler;
import com.userservice.module.service.RoleFeatureInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/rf/v1")
public class RoleFeatureController {
    private RoleFeatureInfoService roleFeatureInfoService;

    public RoleFeatureController(RoleFeatureInfoService roleFeatureInfoService) {
        this.roleFeatureInfoService = roleFeatureInfoService;
    }

    // ************** Create Role Feature **********
    //Url: http://localhost:8181/user/rf/v1/createRoleFeature
    @PostMapping("/createRoleFeature")
    public ResponseEntity<Object> createRoleFeature(@RequestBody RoleFeatureInfoDto roleFeatureInfoDto){
        RoleFeatureInfoDto roleFeatureInfoDtoRes = roleFeatureInfoService.createRoleFeature(roleFeatureInfoDto);
        Map<String,Object> roleFeatureData = new HashMap<>();
        roleFeatureData.put("roleFeatureData",roleFeatureInfoDtoRes);
        return ResponseHandler.responseBuilder("Operation Successful","100",roleFeatureData);
    }

    //************** Find Role Feature By Id ********
    //Url: http://localhost:8181/user/rf/v1/roleFeature/{id}
    @GetMapping("/roleFeature/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        RoleFeatureInfoDto roleFeatureInfoDto = roleFeatureInfoService.getRoleFeature(id);
        Map<String,Object> roleFeatureData = new HashMap<>();
        roleFeatureData.put("roleFeatureData",roleFeatureInfoDto);
        return ResponseHandler.responseBuilder("Operation Successful","100",roleFeatureData);
    }

    //************** Find All Role Feature ***********
    //Url: http://localhost:8181/user/rf/v1/findAll
    @GetMapping("/findAll")
    public ResponseEntity<Object> findAll(){
        List<RoleFeatureInfoDto> roleFeatureInfoDtos = roleFeatureInfoService.getAllRoleFeature();
        System.out.println("res:"+roleFeatureInfoDtos);
        Map<String,Object> roleFeatureData = new HashMap<>();
        roleFeatureData.put("roleFeatureData",roleFeatureData);
        return ResponseHandler.responseBuilder("Operation Successful","100",roleFeatureData);
    }

    //************** Delete Role Feature *************
    //Url: http://localhost:8181/user/rf/deleteById
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        roleFeatureInfoService.deleteRoleFeature(id);
        Map<String,Object> roleFeatureData = new HashMap<>();
        roleFeatureData.put("roleFeatureDeletedId",id);
        roleFeatureData.put("resMsg","Role Feature Deleted Successfully.");
        return ResponseHandler.responseBuilder("Operation Successful.","100",roleFeatureData);
    }

}

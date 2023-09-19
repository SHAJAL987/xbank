package com.userservice.module.controller;

import com.userservice.module.data.RoleInfoData;
import com.userservice.module.payload.RoleInfoDto;
import com.userservice.module.response.ResponseHandler;
import com.userservice.module.service.RoleInfoService;
import com.userservice.module.utils.GlobalItem;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/r/v1")
public class RoleInfoController {

    private RoleInfoService roleInfoService;

    public RoleInfoController(RoleInfoService roleInfoService) {
        this.roleInfoService = roleInfoService;
    }

    //************** Create Role ************
    //Url: http://localhost:8080/user/r/v1/createRole
    @PostMapping("/createRole")
    public ResponseEntity<Object> createRole(@Valid @RequestBody RoleInfoDto roleInfoDto){
        RoleInfoDto roleInfoDtoSave =roleInfoService.saveRole(roleInfoDto);
        Map<String,Object> roleSaveResponse = new HashMap<>();
        roleSaveResponse.put("roleInfo",roleInfoDtoSave);
        return ResponseHandler.responseBuilder("Operation Successful","100",roleSaveResponse);
    }

    //*********** Get Role By Id **************
    //Url: http://localhost:8181/user/r/v1/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Object> getRoleById(@PathVariable("id") Long id){
        RoleInfoDto roleInfoDto = roleInfoService.getRoleInfoById(id);
        Map<String,Object> getRoleResponse = new HashMap<>();
        getRoleResponse.put("roleInfo",roleInfoDto);
        return ResponseHandler.responseBuilder("Operation Successful","100",getRoleResponse);
    }

    //*********** Update Role by Id ***********
    //Url: http://localhost:8181/user/r/v1/{id}
    @PutMapping("{id}")
    public ResponseEntity<Object> updateRoleInfo(@Valid @RequestBody RoleInfoDto roleInfoDto,@PathVariable Long id){
        RoleInfoDto roleInfoDtoRes = roleInfoService.updateRole(roleInfoDto,id);
        Map<String,Object> roleInfoDate = new HashMap<>();
        roleInfoDate.put("roleInfo",roleInfoDtoRes);
        return ResponseHandler.responseBuilder("Operation Successful","100",roleInfoDate);
    }

    //*********** Get All Role *****************
    //Url: http://localhost:8181/user/r/v1/findAll
    @GetMapping("/findAll")
    public ResponseEntity<Object> getAllRoleInfo(){
        List<RoleInfoDto> roleInfoDto = roleInfoService.getAllRoleInfo();
        RoleInfoData roleInfoData = new RoleInfoData();
        roleInfoData.setRoleInfoList(roleInfoDto);
        return ResponseHandler.responseBuilder("Operation Successful","100",roleInfoData);
    }

    //********** Delete RoleInfo ***************
    //Url: http://localhost:8181/user/r/v1/
    @DeleteMapping("{id}")
    public ResponseEntity<Object> getDeleteRoleInfo(@PathVariable Long id){
        roleInfoService.deleteRoleInfo(id);
        Map<String,Object> deletedRoleRes = new HashMap<>();
        deletedRoleRes.put("deletedRoleInfoId",id);
        deletedRoleRes.put("resMsg","Role Info Deleted Successful");
        return ResponseHandler.responseBuilder("Operation Successful","100",deletedRoleRes);
    }

    //*********** Update Role by Id ***********
    //Url: http://localhost:8181/user/r/v1/{id}
    @PutMapping("/approved/{id}")
    public ResponseEntity<Object> approveRoleInfo(@RequestBody RoleInfoDto roleInfoDto,@PathVariable Long id){
        RoleInfoDto roleInfoDtoRes = roleInfoService.updateRole(roleInfoDto,id);
        Map<String,Object> roleInfoDate = new HashMap<>();
        roleInfoDate.put("roleInfo",roleInfoDtoRes);
        roleInfoDate.put("resMsg","Role Approved Successfully");
        return ResponseHandler.responseBuilder("Operation Successful","100",roleInfoDate);
    }

}

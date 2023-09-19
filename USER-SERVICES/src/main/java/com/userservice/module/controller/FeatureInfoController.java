package com.userservice.module.controller;

import com.userservice.module.data.FeatureInfoData;
import com.userservice.module.model.FeatureInfo;
import com.userservice.module.payload.FeatureInfoDto;
import com.userservice.module.response.ResponseHandler;
import com.userservice.module.service.FeatureInfoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/f/v1")
public class FeatureInfoController {
    private FeatureInfoService featureInfoService;

    public FeatureInfoController(FeatureInfoService featureInfoService) {
        this.featureInfoService = featureInfoService;
    }

    //************ Feature Info *****************
    //Url: http://localhost:8181/user/f/v1/createFeature
    @PostMapping("/createFeature")
    public ResponseEntity<Object> createFeature(@Valid @RequestBody FeatureInfoDto featureInfoDto){
        FeatureInfoDto featureInfoDtoRes = featureInfoService.saveFeature(featureInfoDto);
        Map<String,Object> featureInfoData = new HashMap<>();
        featureInfoData.put("featureInfo",featureInfoDtoRes);
        return ResponseHandler.responseBuilder("Operation Successful","100",featureInfoData);
    }

    //************* Get All Feature List *********
    //Url: http://localhost:8181/user/f/v1/findAll
    @GetMapping("/findAll")
    public ResponseEntity<Object> getAllFeatures(){
        List<FeatureInfoDto> featureInfo = featureInfoService.getAllFeature();
        FeatureInfoData featureInfoData = new FeatureInfoData();
        featureInfoData.setFeatureInfoList(featureInfo);
        return ResponseHandler.responseBuilder("Operation Successful","100",featureInfoData);
    }

    //************ Get Feature Info *****************
    //Url: http://localhost:8181/user/f/v1/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Object> getFeatureById(@PathVariable Long id){
        FeatureInfoDto featureInfoDtoRes = featureInfoService.getFeatureById(id);
        Map<String,Object> featureInfoDate = new HashMap<>();
        featureInfoDate.put("featureInfo",featureInfoDtoRes);
        return ResponseHandler.responseBuilder("Operation Successful","100",featureInfoDate);
    }

    //************ Delete Feature Info *****************
    //Url: http://localhost:8181/user/f/v1/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFeatureById(@PathVariable Long id){
        featureInfoService.deleteFeatureInfo(id);
        Map<String,Object> featureInfoData = new HashMap<>();
        featureInfoData.put("DeletedFeatureId",id);
        featureInfoData.put("resMsg","Feature deleted successful");
        return ResponseHandler.responseBuilder("Operation Successful","100",featureInfoData);
    }
}

package com.example.springweb.service;

import com.example.springweb.dao.AddAppUser;
import com.example.springweb.dao.EnterpriseUser;
import com.example.springweb.dao.HelloUser;
import com.example.springweb.mapper.AddAppMapper;
import com.example.springweb.mapper.EnterpriseMapper;
import com.example.springweb.mapper.HelloMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AddAppService {
    @Resource
    private AddAppMapper addAppMapper;

    public List<AddAppUser> getUserList() {
        List<AddAppUser> list = addAppMapper.findAll();
        return list;
    }

    /*public void InsertUser(HelloUser helloUser){
        helloMapper.insert(helloUser);
        System.out.println("Afterinsert:"+helloMapper.findAll());
    }*/
    public void InsertUser(Map<String, String> params){
        ObjectMapper objectMapper = new ObjectMapper();
        AddAppUser addAppUser = objectMapper.convertValue(params, AddAppUser.class);
        addAppMapper.insert(addAppUser);
    }


    public AddAppUser getOne(int id){
        //HelloUser result = new HelloUser();
        AddAppUser result = addAppMapper.getOne(id);
        System.out.println("getOne:"+result);
        if (result==null)
        {
            result=new AddAppUser();//索引为空的时候，返回null，需要这时候对其getId,getName就会出错。
        }
        System.out.println(result.toString());
        return result;
    }

    /*public void UpdateByID(HelloUser helloUser){
        helloMapper.updateByID(helloUser);
        System.out.println("AfterUpdate:"+ helloMapper.getOne(helloUser.getId()));
    }*/
    public void UpdateByID(Map<String, String> params){
        String id1 = params.get("event_id");
        //Long recordId = Long.parseLong(params.get("recordId"));
        //ObjectMapper objectMapper = new ObjectMapper();
        //HelloUser helloUser = objectMapper.convertValue(params, HelloUser.class);
        //helloMapper.updateByID(helloUser);
        int id = Integer.parseInt(String.valueOf(id1));
        AddAppUser temp = addAppMapper.getOne(id);
        if(params.get("user_id")!=null)
            temp.setUser_id(params.get("user_id"));
        if(params.get("app_name")!=null)
            temp.setApp_name(params.get("app_name"));
        if(params.get("range_classify")!=null)
            temp.setRange_classify((params.get("range_classify")));
        if(params.get("range_Info")!=null)
            temp.setRange_Info((params.get("range_Info")));
        if(params.get("operation_classify")!=null)
            temp.setOperation_classify((params.get("operation_classify")));
        if(params.get("operation_Info")!=null)
            temp.setOperation_Info((params.get("operation_Info")));
        if(params.get("type_classify")!=null)
            temp.setType_classify((params.get("type_classify")));
        if(params.get("type_Info")!=null)
            temp.setType_Info((params.get("type_Info")));
        if(params.get("safe_level")!=null)
            temp.setSafe_level((params.get("safe_level")));
        if(params.get("index1_level")!=null)
            temp.setIndex1_level((params.get("index1_level")));
        if(params.get("index1_Info")!=null)
            temp.setIndex1_Info((params.get("index1_Info")));
        if(params.get("index2_level")!=null)
            temp.setIndex2_level((params.get("index2_level")));
        if(params.get("index2_Info")!=null)
            temp.setIndex2_Info((params.get("index2_Info")));
        if(params.get("index3_level")!=null)
            temp.setIndex3_level((params.get("index3_level")));
        if(params.get("index3_Info")!=null)
            temp.setIndex3_Info((params.get("index3_Info")));
        addAppMapper.updateByID(temp);
    }

    public int GetTotal() {
        return addAppMapper.count();
    }

    public void UpdateUserId(int event_id, String user_id) {
        AddAppUser temp = addAppMapper.getOne(event_id);
        if(user_id != null)
            temp.setUser_id(user_id);
        addAppMapper.updateUserId(user_id, event_id);
    }

    public void UpdateAppName(int id, String app_name) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(app_name != null)
            temp.setApp_name(app_name);
        addAppMapper.updateAppName(app_name, id);
    }

    public void UpdateRangeClassify(int id, String range_classify) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(range_classify != null)
            temp.setRange_classify(range_classify);
        addAppMapper.updateRangeClassify(range_classify, id);
    }

    public void UpdateRangeInfo(int id, String range_Info) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(range_Info != null)
            temp.setRange_Info(range_Info);
        addAppMapper.updateRangeInfo(range_Info, id);
    }

    public void UpdateOperationClassify(int id, String operation_classify) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(operation_classify != null)
            temp.setOperation_classify(operation_classify);
        addAppMapper.updateOperationClassify(operation_classify, id);
    }

    public void UpdateOperationInfo(int id, String operation_Info) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(operation_Info != null)
            temp.setOperation_Info(operation_Info);
        addAppMapper.updateOperationInfo(operation_Info, id);
    }

    public void UpdateTypeClassify(int id, String type_classify) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(type_classify!= null)
            temp.setType_classify(type_classify);
        addAppMapper.updateTypeClassify(type_classify, id);
    }

    public void UpdateTypeInfo(int id, String type_Info) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(type_Info!= null)
            temp.setType_Info(type_Info);
        addAppMapper.updateTypeInfo(type_Info, id);
    }

    public void UpdateSafeLevel(int id, String safe_level) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(safe_level!= null)
            temp.setType_Info(safe_level);
        addAppMapper.updateSafeLevel(safe_level, id);
    }

    public void UpdateIndex1Level(int id, String index1Level) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(index1Level!= null)
            temp.setIndex1_level(index1Level);
        addAppMapper.updateIndex1Level(index1Level, id);
    }

    public void UpdateIndex1Info(int id, String index1Info) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(index1Info!= null)
            temp.setIndex1_Info(index1Info);
        addAppMapper.updateIndex1Info(index1Info, id);
    }

    public void UpdateIndex2Level(int id, String index2Level) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(index2Level!= null)
            temp.setIndex2_level(index2Level);
        addAppMapper.updateIndex2Level(index2Level, id);
    }

    public void UpdateIndex2Info(int id, String index2Info) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(index2Info!= null)
            temp.setIndex2_Info(index2Info);
        addAppMapper.updateIndex2Info(index2Info, id);
    }

    public void UpdateIndex3Level(int id, String index3Level) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(index3Level!= null)
            temp.setIndex3_level(index3Level);
        addAppMapper.updateIndex3Level(index3Level, id);
    }

    public void UpdateIndex3Info(int id, String index3Info) {
        AddAppUser temp = addAppMapper.getOne(id);
        if(index3Info!= null)
            temp.setIndex3_Info(index3Info);
        addAppMapper.updateIndex3Info(index3Info, id);
    }

    public void DeleteByID(int id){
        addAppMapper.deleteByID(id);
        System.out.println("AfterDelete:"+addAppMapper.getOne(id));
    }

}

package com.example.springweb.service;

import com.example.springweb.dao.EnterpriseUser;
import com.example.springweb.dao.HelloUser;
import com.example.springweb.mapper.EnterpriseMapper;
import com.example.springweb.mapper.HelloMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EnterpriseService {
    @Resource
    private EnterpriseMapper enterpriseMapper;

    public List<EnterpriseUser> getUserList() {
        List<EnterpriseUser> list = enterpriseMapper.findAll();
        return list;
    }

    /*public void InsertUser(HelloUser helloUser){
        helloMapper.insert(helloUser);
        System.out.println("Afterinsert:"+helloMapper.findAll());
    }*/
    public void InsertUser(Map<String, String> params){
        ObjectMapper objectMapper = new ObjectMapper();
        EnterpriseUser enterpriseUser = objectMapper.convertValue(params, EnterpriseUser.class);
        enterpriseMapper.insert(enterpriseUser);
    }


    public EnterpriseUser getOne(String id){
        //HelloUser result = new HelloUser();
        EnterpriseUser result = enterpriseMapper.getOne(id);
        System.out.println("getOne:"+result);
        if (result==null)
        {
            result=new EnterpriseUser();//索引为空的时候，返回null，需要这时候对其getId,getName就会出错。
        }
        System.out.println(result.toString());
        return result;
    }

    /*public void UpdateByID(HelloUser helloUser){
        helloMapper.updateByID(helloUser);
        System.out.println("AfterUpdate:"+ helloMapper.getOne(helloUser.getId()));
    }*/
    public void UpdateByID(Map<String, String> params){
        String id = params.get("id");
        //Long recordId = Long.parseLong(params.get("recordId"));
        //ObjectMapper objectMapper = new ObjectMapper();
        //HelloUser helloUser = objectMapper.convertValue(params, HelloUser.class);
        //helloMapper.updateByID(helloUser);
        EnterpriseUser temp = enterpriseMapper.getOne(id);
        if(params.get("name")!=null)
            temp.setName(params.get("name"));
        if(params.get("password")!=null)
            temp.setPassword((params.get("password")));
        enterpriseMapper.updateByID(temp);
    }


    public void DeleteByID(String id){
        enterpriseMapper.deleteByID(id);
        System.out.println("AfterDelete:"+enterpriseMapper.getOne(id));
    }

    public String login(String name, String password) {
        return enterpriseMapper.login(name, password);
    }
}

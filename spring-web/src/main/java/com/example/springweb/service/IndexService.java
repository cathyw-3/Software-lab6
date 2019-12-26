package com.example.springweb.service;

import com.example.springweb.dao.HelloUser;
import com.example.springweb.dao.IndexUser;
import com.example.springweb.mapper.HelloMapper;
import com.example.springweb.mapper.IndexMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class IndexService {
    @Resource
    private IndexMapper indexMapper;

    public List<IndexUser> getUserList() {
        List<IndexUser> list = indexMapper.findAll();
        return list;
    }

    /*public void InsertUser(HelloUser helloUser){
        helloMapper.insert(helloUser);
        System.out.println("Afterinsert:"+helloMapper.findAll());
    }*/
    public void InsertUser(Map<String, String> params){
        ObjectMapper objectMapper = new ObjectMapper();
        IndexUser indexUser = objectMapper.convertValue(params, IndexUser.class);
        indexMapper.insert(indexUser);
    }


    public IndexUser getOne(String id){
        //HelloUser result = new HelloUser();
        IndexUser result = indexMapper.getOne(id);
        System.out.println("getOne:"+result);
        if (result==null)
        {
            result=new IndexUser();//索引为空的时候，返回null，需要这时候对其getId,getName就会出错。
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
        IndexUser temp = indexMapper.getOne(id);
        if(params.get("name")!=null)
            temp.setName(params.get("name"));
        if(params.get("password")!=null)
            temp.setPassword((params.get("password")));
        indexMapper.updateByID(temp);
    }


    public void DeleteByID(String id){
        indexMapper.deleteByID(id);
        System.out.println("AfterDelete:"+indexMapper.getOne(id));
    }
}

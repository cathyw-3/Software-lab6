package com.example.springweb.mapper;

import com.example.springweb.dao.EnterpriseUser;
import com.example.springweb.dao.HelloUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EnterpriseMapper {
    @Select("select * from user ")
    @Results({
            @Result(property = "id", column = "stringId"),
            @Result(property = "name", column = "user_name"),
            @Result(property = "password", column = "password")
    })
    List<EnterpriseUser> findAll();

    @Insert("insert into user(stringId,user_name,password) values(#{id},#{name},#{password})")
    void insert(EnterpriseUser enterpriseUser);


    @Select("select * from user where stringId = #{id}")
    @Results({
            @Result(property = "id",column = "stringId"),
            @Result(property = "name",column = "user_name"),
            @Result(property = "password", column = "password")
    })
    EnterpriseUser getOne(String id);

    @Update("update user set user_name = #{name}, password = #{password} where StringId = #{id}")
    void updateByID(EnterpriseUser enterpriseUser);//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值

    @Delete("delete from user where StringId = #{id}")
    void deleteByID(String id);//DELETE FROM 表名称 WHERE 列名称 = 值


    @Select("select StringId from user where user_name=#{name} and password=#{password}")
    public String login(@Param("name") String user_name,@Param("password") String password);
}

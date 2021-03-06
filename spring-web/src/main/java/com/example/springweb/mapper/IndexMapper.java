package com.example.springweb.mapper;

import com.example.springweb.dao.HelloUser;
import com.example.springweb.dao.IndexUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IndexMapper {
    @Select("select * from user ")
    @Results({
            @Result(property = "id", column = "stringId"),
            @Result(property = "name", column = "user_name")
    })
    List<IndexUser> findAll();

    @Insert("insert into user(stringId,user_name,password) values(#{id},#{name},#{password})")
    void insert(IndexUser indexUser);


    @Select("select * from user where stringId = #{id}")
    @Results({
            @Result(property = "id",column = "stringId"),
            @Result(property = "name",column = "user_name")
    })
    IndexUser getOne(String id);

    @Update("update user set user_name = #{name}, password = #{password} where StringId = #{id}")
    void updateByID(IndexUser indexUser);//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值

    @Delete("delete from user where StringId = #{id}")
    void deleteByID(String id);//DELETE FROM 表名称 WHERE 列名称 = 值
}

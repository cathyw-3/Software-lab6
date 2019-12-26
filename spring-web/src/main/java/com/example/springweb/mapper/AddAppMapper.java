package com.example.springweb.mapper;

import com.example.springweb.dao.AddAppUser;
import com.example.springweb.dao.EnterpriseUser;
import com.example.springweb.dao.HelloUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddAppMapper {
    @Select("select * from AppInfo")
    @Results({
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "app_name", column = "app_name"),
            @Result(property = "range_classify", column = "range_classify"),
            @Result(property = "operation_classify", column = "operation_classify"),
            @Result(property = "type_classify", column = "type_classify"),
            @Result(property = "safe_level", column = "safe_level"),
            @Result(property = "index1_level", column = "index1_level"),
            @Result(property = "index1_Info", column = "index1_Info"),
            @Result(property = "index2_level", column = "index2_level"),
            @Result(property = "index2_Info", column = "index2_Info"),
            @Result(property = "index3_level", column = "index3_level"),
            @Result(property = "index3_Info", column = "index3_Info")
    })
    List<AddAppUser> findAll();

    @Insert("insert into AppInfo(event_id, user_id, app_name, range_classify, range_Info, operation_classify, operation_Info, type_classify, type_Info, safe_level, index1_level, index1_Info, index2_level, index2_Info, index3_level, index3_Info) values(#{event_id},#{user_id},#{app_name},#{range_classify},#{range_Info},#{operation_classify},#{operation_Info},#{type_classify},#{type_Info},#{safe_level},#{index1_level},#{index1_Info},#{index2_level},#{index2_Info},#{index3_level},#{index3_Info})")
    void insert(AddAppUser addAppUser);


    @Select("select * from AppInfo where event_id=#{event_id}")
    @Results({
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "app_name", column = "app_name"),
            @Result(property = "range_classify", column = "range_classify"),
            @Result(property = "range_Info", column = "range_Info"),
            @Result(property = "operation_classify", column = "operation_classify"),
            @Result(property = "operation_Info", column = "operation_Info"),
            @Result(property = "type_classify", column = "type_classify"),
            @Result(property = "type_Info", column = "type_Info"),
            @Result(property = "safe_level", column = "safe_level"),
            @Result(property = "index1_level", column = "index1_level"),
            @Result(property = "index1_Info", column = "index1_Info"),
            @Result(property = "index2_level", column = "index2_level"),
            @Result(property = "index2_Info", column = "index2_Info"),
            @Result(property = "index3_level", column = "index3_level"),
            @Result(property = "index3_Info", column = "index3_Info")
    })
    AddAppUser getOne(int id);

    @Select("select count(*) from AppInfo")
    public int count();

    @Update("update AppInfo set user_id=#{user_id},app_name=#{app_name},range_classify=#{range_classify},range_Info=#{range_Info},operation_classify=#{operation_classify},operation_Info=#{operation_Info},type_classify=#{type_classify},type_Info=#{type_Info},safe_level=#{safe_level},index1_level=#{index1_level},index1_Info=#{index1_Info},index2_level=#{index2_level},index2_Info=#{index2_Info},index3_level=#{index3_level},index3_Info=#{index3_Info} where event_id = #{event_id}")
    void updateByID(AddAppUser addAppUser);//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值

    @Update("update AppInfo set user_id=#{user_id} where event_id=#{event_id}")
    void updateUserId(@Param("user_id") String user_id, @Param("event_id") int event_id);

    @Update("update AppInfo set app_name=#{app_name} where event_id=#{event_id}")
    void updateAppName(@Param("app_name") String app_name, @Param("event_id") int event_id);

    @Update("update AppInfo set range_classify=#{range_classify} where event_id=#{event_id}")
    void updateRangeClassify(@Param("range_classify") String range_classify, @Param("event_id") int event_id);

    @Update("update AppInfo set range_Info=#{range_Info} where event_id=#{event_id}")
    void updateRangeInfo(@Param("range_Info") String range_Info, @Param("event_id") int event_id);

    @Update("update AppInfo set operation_classify=#{operation_classify} where event_id=#{event_id}")
    void updateOperationClassify(@Param("operation_classify") String operation_classify, @Param("event_id") int event_id);

    @Update("update AppInfo set operation_Info=#{operation_Info} where event_id=#{event_id}")
    void updateOperationInfo(@Param("operation_Info") String operation_Info, @Param("event_id") int event_id);

    @Update("update AppInfo set type_classify=#{type_classify} where event_id=#{event_id}")
    void updateTypeClassify(@Param("type_classify") String type_classify, @Param("event_id") int event_id);

    @Update("update AppInfo set type_Info=#{type_Info} where event_id=#{event_id}")
    void updateTypeInfo(@Param("type_Info") String type_Info, @Param("event_id") int event_id);

    @Update("update AppInfo set safe_level=#{safe_level} where event_id=#{event_id}")
    void updateSafeLevel(@Param("safe_level") String safe_level, @Param("event_id") int event_id);

    @Update("update AppInfo set index1_level=#{index1_level} where event_id=#{event_id}")
    void updateIndex1Level(@Param("index1_level") String index1_level, @Param("event_id") int event_id);

    @Update("update AppInfo set index1_Info=#{index1_Info} where event_id=#{event_id}")
    void updateIndex1Info(@Param("index1_Info") String index1_Info, @Param("event_id") int event_id);

    @Update("update AppInfo set index2_level=#{index2_level} where event_id=#{event_id}")
    void updateIndex2Level(@Param("index2_level") String index2_level, @Param("event_id") int event_id);

    @Update("update AppInfo set index2_Info=#{index2_Info} where event_id=#{event_id}")
    void updateIndex2Info(@Param("index2_Info") String index2_Info, @Param("event_id") int event_id);

    @Update("update AppInfo set index3_level=#{index3_level} where event_id=#{event_id}")
    void updateIndex3Level(@Param("index3_level") String index3_level, @Param("event_id") int event_id);

    @Update("update AppInfo set index3_Info=#{index3_Info} where event_id=#{event_id}")
    void updateIndex3Info(@Param("index3_Info") String index3_Info, @Param("event_id") int event_id);

    @Delete("delete from AppInfo where event_id=#{event_id}")
    void deleteByID(int id);//DELETE FROM 表名称 WHERE 列名称 = 值


}

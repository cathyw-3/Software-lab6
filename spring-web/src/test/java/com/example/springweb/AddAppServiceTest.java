package com.example.springweb;

import com.example.springweb.dao.AddAppUser;
import com.example.springweb.service.AddAppService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddAppServiceTest {
    @Autowired
    AddAppService addAppService;

    @Test
    public void test1Getlist() {
        List<AddAppUser> Users = addAppService.getUserList();
        assertNotNull(Users);
        assertEquals(12, Users.get(11).getEvent_id());
        assertEquals("1", Users.get(11).getUser_id());
        assertEquals("企业资产优化数据分析软件", Users.get(11).getApp_name());
        assertEquals("基础共性工业APP", Users.get(11).getRange_classify());
        assertEquals("这是一个基础共性APP", Users.get(11).getRange_Info());
        assertEquals("节能服务类", Users.get(11).getOperation_classify());
        assertNull(Users.get(11).getOperation_Info());
        assertEquals("业务信息化类", Users.get(11).getType_classify());
        assertEquals("这是属于业务信息化类。", Users.get(11).getType_Info());
        assertEquals("C", Users.get(11).getSafe_level());
        assertEquals("五级", Users.get(11).getIndex1_level());
        assertEquals("提供资料、验证报告、认证证明等", Users.get(11).getIndex1_Info());
        assertEquals("三级", Users.get(11).getIndex2_level());
        assertEquals("相关说明阐述资料、应用验证报告、认证证明", Users.get(11).getIndex2_Info());
        assertEquals("二级", Users.get(11).getIndex3_level());
        assertEquals("", Users.get(11).getIndex3_Info());
    }

    @Test
    public void test2Insert() {
        Map<String, String> addAppUser = new HashMap<String, String>();
        addAppUser.put("event_id", "14");
        addAppUser.put("user_id", "2");
        addAppUser.put("app_name", "通用资产优化数据分析软件");
        addAppService.InsertUser(addAppUser);
        List<AddAppUser> Users = addAppService.getUserList();
        assertNotNull(Users);
        assertEquals(14, Users.get(13).getEvent_id());
        assertEquals("2", Users.get(13).getUser_id());
        assertEquals("通用资产优化数据分析软件", Users.get(13).getApp_name());
        assertNull(Users.get(13).getRange_classify());
        assertNull(Users.get(13).getRange_Info());
        assertNull(Users.get(13).getOperation_classify());
        assertNull(Users.get(13).getOperation_Info());
        assertNull(Users.get(13).getType_classify());
        assertNull(Users.get(13).getType_Info());
        assertNull(Users.get(13).getSafe_level());
        assertNull(Users.get(13).getIndex1_level());
        assertNull(Users.get(13).getIndex1_Info());
        assertNull(Users.get(13).getIndex2_level());
        assertNull(Users.get(13).getIndex2_Info());
        assertNull(Users.get(13).getIndex3_level());
        assertNull(Users.get(13).getIndex3_Info());
    }

    @Test
    public void test3Getone1() {
        int id = 10;
        AddAppUser user = addAppService.getOne(id);
        assertEquals(10, user.getEvent_id());
        assertEquals("2", user.getUser_id());
        assertEquals("企业资产优化数据分析APP", user.getApp_name());
        assertEquals("其他工业APP", user.getRange_classify());
        assertEquals("你猜", user.getRange_Info());
        assertEquals("健康评价类", user.getOperation_classify());
        assertNull(user.getOperation_Info());
        assertEquals("数据分析类", user.getType_classify());
        assertEquals("就是数据分析", user.getType_Info());
        assertEquals("B", user.getSafe_level());
        assertNull(user.getIndex1_level());
        assertNull(user.getIndex1_Info());
        assertNull(user.getIndex2_level());
        assertNull(user.getIndex2_Info());
        assertNull(user.getIndex3_level());
        assertNull(user.getIndex3_Info());
    }

    @Test
    public void test3Getone2() {
        int id = 20;
        AddAppUser user = addAppService.getOne(id);
        assertNull(user.getUser_id());
        assertNull(user.getApp_name());
        assertNull(user.getRange_classify());
        assertNull(user.getRange_Info());
        assertNull(user.getOperation_classify());
        assertNull(user.getOperation_Info());
        assertNull(user.getType_classify());
        assertNull(user.getType_Info());
        assertNull(user.getSafe_level());
        assertNull(user.getIndex1_level());
        assertNull(user.getIndex1_Info());
        assertNull(user.getIndex2_level());
        assertNull(user.getIndex2_Info());
        assertNull(user.getIndex3_level());
        assertNull(user.getIndex3_Info());
    }

    @Test
    public void test4Updatebyid() {
        Map<String, String> addAppUser = new HashMap<String, String>();
        addAppUser.put("event_id", "11");
        addAppUser.put("range_Info", "这是修改后的行业通用工业APP");
        addAppService.UpdateByID(addAppUser);
        List<AddAppUser> user = addAppService.getUserList();
        assertEquals(11, user.get(10).getEvent_id());
        assertEquals("1", user.get(10).getUser_id());
        assertEquals("企业资产优化数据分析软件", user.get(10).getApp_name());
        assertEquals("行业通用工业APP", user.get(10).getRange_classify());
        assertEquals("这是修改后的行业通用工业APP", user.get(10).getRange_Info());
    }

    @Test
    public void test5Gettotal() {
        int count = addAppService.GetTotal();
        assertEquals(14, count);
    }

    @Test
    public void test6Deletebyid1() {
        addAppService.DeleteByID(14);
        AddAppUser user = addAppService.getOne(14);
        assertNull(user.getUser_id());
        assertNull(user.getApp_name());
        assertNull(user.getRange_classify());
        assertNull(user.getRange_Info());
        assertNull(user.getOperation_classify());
        assertNull(user.getOperation_Info());
        assertNull(user.getType_classify());
        assertNull(user.getType_Info());
        assertNull(user.getSafe_level());
        assertNull(user.getIndex1_level());
        assertNull(user.getIndex1_Info());
        assertNull(user.getIndex2_level());
        assertNull(user.getIndex2_Info());
        assertNull(user.getIndex3_level());
        assertNull(user.getIndex3_Info());
    }

    @Test
    public void test6Deletebyid2() {
        addAppService.DeleteByID(14);
        AddAppUser user = addAppService.getOne(14);
        assertNull(user.getUser_id());
        assertNull(user.getApp_name());
        assertNull(user.getRange_classify());
        assertNull(user.getRange_Info());
        assertNull(user.getOperation_classify());
        assertNull(user.getOperation_Info());
        assertNull(user.getType_classify());
        assertNull(user.getType_Info());
        assertNull(user.getSafe_level());
        assertNull(user.getIndex1_level());
        assertNull(user.getIndex1_Info());
        assertNull(user.getIndex2_level());
        assertNull(user.getIndex2_Info());
        assertNull(user.getIndex3_level());
        assertNull(user.getIndex3_Info());
    }
}

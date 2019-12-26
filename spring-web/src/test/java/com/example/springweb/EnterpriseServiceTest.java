package com.example.springweb;

import com.example.springweb.dao.EnterpriseUser;
import com.example.springweb.service.EnterpriseService;
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
public class EnterpriseServiceTest {
    @Autowired
    EnterpriseService enterpriseService;

    @Test
    public void test1Getlist() {
        List<EnterpriseUser> Users = enterpriseService.getUserList();
        assertNotNull(Users);
        assertEquals("1", Users.get(0).getId());
        assertEquals("John Wang", Users.get(0).getName());
        assertEquals("wangyinchi", Users.get(0).getPassword());
        assertEquals("2", Users.get(1).getId());
        assertEquals("admin", Users.get(1).getName());
        assertEquals("123456", Users.get(1).getPassword());
    }

    @Test
    public void test2Insert1() {
        Map<String, String> enterpriseUser = new HashMap<String, String>();
        enterpriseUser.put("id", "3");
        enterpriseUser.put("name", "suibian");
        enterpriseUser.put("password", "buzhidao");
        enterpriseService.InsertUser(enterpriseUser);
        List<EnterpriseUser> Users = enterpriseService.getUserList();
        assertNotNull(Users);
        assertEquals("3", Users.get(2).getId());
        assertEquals("suibian", Users.get(2).getName());
        assertEquals("buzhidao", Users.get(2).getPassword());
    }

    @Test
    public void test2Insert2() {
        Map<String, String> enterpriseUser = new HashMap<String, String>();
        enterpriseUser.put("id", "4");
        enterpriseUser.put("name", "中文名测试");
        enterpriseUser.put("password", "&^%$#");
        enterpriseService.InsertUser(enterpriseUser);
        List<EnterpriseUser> Users = enterpriseService.getUserList();
        assertNotNull(Users);
        assertEquals("4", Users.get(3).getId());
        assertEquals("中文名测试", Users.get(3).getName());
        assertEquals("&^%$#", Users.get(3).getPassword());
    }

    @Test
    public void test3Getone1() {
        EnterpriseUser user = enterpriseService.getOne("2");
        assertNotNull(user);
        assertEquals("2", user.getId());
        assertEquals("admin", user.getName());
        assertEquals("123456", user.getPassword());
    }

    @Test
    public void test3Getone2() {
        EnterpriseUser user = enterpriseService.getOne("5");
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getPassword());
    }

    @Test
    public void test4Updatebyid() {
        Map<String, String> enterpriseUser = new HashMap<String, String>();
        enterpriseUser.put("id", "2");
        enterpriseUser.put("name", "其他");
        enterpriseUser.put("password", "87654321");
        enterpriseService.UpdateByID(enterpriseUser);
        List<EnterpriseUser> Users = enterpriseService.getUserList();
        assertNotNull(Users);
        assertEquals("2", Users.get(1).getId());
        assertEquals("其他", Users.get(1).getName());
        assertEquals("87654321", Users.get(1).getPassword());
    }

    @Test
    public void test5Deletebyid1() {
        enterpriseService.DeleteByID("3");
        EnterpriseUser user = enterpriseService.getOne("3");
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getPassword());
    }

    @Test
    public void test5Deletebyid2() {
        enterpriseService.DeleteByID("3");
        EnterpriseUser user = enterpriseService.getOne("3");
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getPassword());
    }

    @Test
    public void test6Login1() {
        String name = "John Wang";
        String password = "wangyinchi";
        String id = enterpriseService.login(name, password);
        assertEquals("1", id);
    }

    @Test
    public void test6Login2() {
        String name = "admin";
        String password = "wangyinchi";
        String id = enterpriseService.login(name, password);
        assertNull(id);
    }
}

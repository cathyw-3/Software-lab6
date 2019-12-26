package com.example.springweb.controller;

import com.example.springweb.dao.AddAppUser;
import com.example.springweb.service.AddAppService;
import com.example.springweb.service.EnterpriseService;
import com.example.springweb.service.HelloService;
import com.example.springweb.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    AddAppService addAppService;
    private String gt;
    private int i;

    @RequestMapping(value = "/home_page", method = {RequestMethod.POST})
    public String login(HttpServletRequest request, HttpSession session) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("你输入的用户名为：" + name);
        System.out.println("你输入的密码为：" + password);
        gt = enterpriseService.login(name, password);
        session.setAttribute("name", gt);
        System.out.println("gt为：" + gt);
        if (gt == null) {
            return "redirect:/enterprise_login";
        } else {
            return "redirect:/home_page";
        }
    }

    @RequestMapping(value = "/addApp/addApp2", method = {RequestMethod.POST})
    public String page2(HttpServletRequest request, HttpSession session) {
        if (gt == null) {
            return "redirect:/enterprise_login";
        } else {
            System.out.println("当前用户ID为：" + gt);
            i = addAppService.GetTotal() + 1;
            String Range_Classify = request.getParameter("range_classify");
            System.out.println("你的业务范围类型为：" + Range_Classify);

            if (Range_Classify==null) {
                return "redirect:/addApp/addApp1";
            }
            else {
                Map<String, String> param = new HashMap<String, String>();
                String i_2_s = String.valueOf(i);
                param.put("event_id", i_2_s);
                addAppService.InsertUser(param);
                System.out.println("Insert 成功");
                addAppService.UpdateUserId(i, gt);
                addAppService.UpdateRangeClassify(i, Range_Classify);
                String Range_Info = request.getParameter("range_Info");
                addAppService.UpdateRangeInfo(i, Range_Info);
                System.out.print("Update 成功");
                return "redirect:/addApp/addApp2";
            }
        }
    }

    @RequestMapping(value = "/addApp/addApp3", method = {RequestMethod.POST})
    public String page3(HttpServletRequest request, HttpSession session) {
        if (gt == null) {
            return "redirect:/enterprise_login";
        } else {
            System.out.println("当前用户ID为：" + gt);
            String Operation_Classify = request.getParameter("operation_classify");
            System.out.println("你的业务环节类型为：" + Operation_Classify);

            if (Operation_Classify==null) {
                return "redirect:/addApp/addApp2";
            }
            else {
                addAppService.UpdateOperationClassify(i, Operation_Classify);
                System.out.print("Update 成功");
                return "redirect:/addApp/addApp3";
            }
        }
    }

    @RequestMapping(value = "/addApp/addApp4", method = {RequestMethod.POST})
    public String page4(HttpServletRequest request, HttpSession session) {
        if (gt == null) {
            return "redirect:/enterprise_login";
        } else {
            System.out.println("当前用户ID为：" + gt);
            String Type_Classify = request.getParameter("type_classify");
            System.out.println("你的业务环节类型为：" + Type_Classify);

            if (Type_Classify==null) {
                return "redirect:/addApp/addApp3";
            }
            else {
                addAppService.UpdateTypeClassify(i, Type_Classify);
                String Type_Info = request.getParameter("type_Info");
                addAppService.UpdateTypeInfo(i, Type_Info);
                System.out.print("Update 成功");
                return "redirect:/addApp/addApp4";
            }
        }
    }

    @RequestMapping(value = "/addApp/addApp5", method = {RequestMethod.POST})
    public String page5(HttpServletRequest request, HttpSession session) {
        if (gt == null) {
            return "redirect:/enterprise_login";
        } else {
            System.out.println("当前用户ID为：" + gt);
            String string1 = request.getParameter("field");
            String string2 = request.getParameter("operation");
            String string3 = request.getParameter("function");
            String string4 = request.getParameter("name");
            String App_Name = string1+string2+string3+string4;
            if (App_Name==null) {
                return "redirect:/addApp/addApp4";
            }
            else {
                addAppService.UpdateAppName(i, App_Name);
                System.out.print("Update 成功");
                return "redirect:/addApp/addApp5";
            }
        }
    }

    @RequestMapping(value = "/addApp/addApp6", method = {RequestMethod.POST})
    public String page6(HttpServletRequest request, HttpSession session) {
        if (gt == null) {
            return "redirect:/enterprise_login";
        } else {
            String Safe_Level = request.getParameter("safe_level");
            if (Safe_Level==null) {
                return "redirect:/addApp/addApp5";
            }
            else {
                addAppService.UpdateSafeLevel(i, Safe_Level);
                System.out.print("Update 成功");
                return "redirect:/addApp/addApp6";
            }
        }
    }

    @RequestMapping(value = "/addApp/addApp7", method = {RequestMethod.POST})
    public String page7(HttpServletRequest request, HttpSession session) {
        if (gt == null) {
            return "redirect:/enterprise_login";
        } else {
            String Index1_Level = request.getParameter("index1_level");
            if (Index1_Level==null) {
                return "redirect:/addApp/addApp6";
            }
            else {
                addAppService.UpdateIndex1Level(i, Index1_Level);
                String Index1_Info = request.getParameter("index1_Info");
                addAppService.UpdateIndex1Info(i, Index1_Info);
                System.out.print("Update 成功");
                return "redirect:/addApp/addApp7";
            }
        }
    }

    @RequestMapping(value = "/addApp/addApp8", method = {RequestMethod.POST})
    public String page8(HttpServletRequest request, HttpSession session) {
        if (gt == null) {
            return "redirect:/enterprise_login";
        } else {
            String Index2_Level = request.getParameter("index2_level");
            if (Index2_Level==null) {
                return "redirect:/addApp/addApp7";
            }
            else {
                addAppService.UpdateIndex2Level(i, Index2_Level);
                String Index2_Info = request.getParameter("index2_Info");
                addAppService.UpdateIndex2Info(i, Index2_Info);
                System.out.print("Update 成功");
                return "redirect:/addApp/addApp8";
            }
        }
    }

    @RequestMapping(value = "/addApp/addApp9", method = {RequestMethod.POST})
    public String page9(HttpServletRequest request, HttpSession session) {
        if (gt == null) {
            return "redirect:/enterprise_login";
        } else {
            String Index3_Level = request.getParameter("index3_level");
            if (Index3_Level==null) {
                return "redirect:/addApp/addApp8";
            }
            else {
                addAppService.UpdateIndex3Level(i, Index3_Level);
                String Index3_Info = request.getParameter("index3_Info");
                addAppService.UpdateIndex3Info(i, Index3_Info);
                System.out.print("Update 成功");
                return "redirect:/addApp/addApp9";
            }
        }
    }

}

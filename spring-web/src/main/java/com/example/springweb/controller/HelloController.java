package com.example.springweb.controller;

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

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;

    public final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello() {
        logger.info("hello logging" + helloService.getUserList());
        return "hello";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/enterprise_login")
    public String enterprise_login() {
        return "enterprise_login";
    }

    @RequestMapping("/home_page")
    public String home_page() {
        return "home_page";
    }

    @RequestMapping("/addApp/addApp1")
    public String addApp1() {
        return "addApp/addApp1";
    }

    @RequestMapping("/addApp/addApp2")
    public String addApp2() {
        return "addApp/addApp2";
    }

    @RequestMapping("/addApp/addApp3")
    public String addApp3() {
        return "addApp/addApp3";
    }

    @RequestMapping("/addApp/addApp4")
    public String addApp4() {
        return "addApp/addApp4";
    }

    @RequestMapping("/addApp/addApp5")
    public String addApp5() {
        return "addApp/addApp5";
    }

    @RequestMapping("/addApp/addApp6")
    public String addApp6() {
        return "addApp/addApp6";
    }

    @RequestMapping("/addApp/addApp7")
    public String addApp7() {
        return "addApp/addApp7";
    }

    @RequestMapping("/addApp/addApp8")
    public String addApp8() {
        return "addApp/addApp8";
    }

    @RequestMapping("/addApp/addApp9")
    public String addApp9() {
        return "addApp/addApp9";
    }
}

package com.example.springweb.controller;

import com.example.springweb.service.HelloService;
import com.example.springweb.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    @Autowired
    IndexService indexService;
    public final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String index(){
        logger.info("index logging" + indexService.getUserList());
        return "index";
    }
}

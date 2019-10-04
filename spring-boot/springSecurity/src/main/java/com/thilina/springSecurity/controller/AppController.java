package com.thilina.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public  String getHomePage(){
        return "home";
    }

    @GetMapping("/webprivate")
    public  String getWebprivatePage(){
        return "webprivate";
    }

    @GetMapping("/webadmin")
    public  String getWebadminPage(){
        return "webadmin";
    }

    @GetMapping("/login")
    public  String getLoginPage(){
        return "login";
    }

}

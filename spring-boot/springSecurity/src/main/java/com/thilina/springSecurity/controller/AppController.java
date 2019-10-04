package com.thilina.springSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class AppController {



    @GetMapping("/")
    public  String getHomePage(){
        return "home";
    }

    @GetMapping("/webprivate")
    public  String getWebprivatePage(Principal principal,Model model){
        model.addAttribute("uname",principal.getName());
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

//    @Bean
//    public String currentUserName(Principal principal) {
//        return principal.getName();
//    }
}

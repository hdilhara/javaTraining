package com.example.demoSecurity.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class AppController {


    @GetMapping("/")
    public String home(){
       return "home";
    }
    @GetMapping("/private")
    public String getprivate(Principal principal,Model model){
        model.addAttribute("name",principal.getName());
        return "private";
    }
    @GetMapping("/admin")
    public String getAdmin(Principal principal,Model model){
        model.addAttribute("name",principal.getName());
        return "Admin";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
}

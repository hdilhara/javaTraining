package com.thilina.UIemployeeManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {

    @RequestMapping(value = "/")
    public String homePage(){
        return "home";
    }

    @RequestMapping(value = "/ems")
    public String emsPage() {
        return "ems";
    }
}

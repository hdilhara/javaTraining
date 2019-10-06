package com.thilina.employeeManagementSystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @RequestMapping("/api")
    public String apiRootPage(){
        return "API root mapping";
    }
}

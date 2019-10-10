package com.thilina.taskService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @RequestMapping("/")
    public String rootDirectroy(){
        return "This is task root";
    }

//    @RequestMapping("/ems/tasks")
//    public  String getTaskForProject(){
//
//    }
}

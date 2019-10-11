package com.thilina.taskService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {

    @RequestMapping("/ems/tasks")
    public String getAllTasks(){

    }
}

package com.thilina.taskService.controller;

import com.thilina.taskService.dao.Tasks;
import com.thilina.taskService.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    public TaskService taskService;

    @RequestMapping("/ems/tasks")
    public List<Tasks> getAllTasks(){
        return taskService.getAllTasks();
    }
}

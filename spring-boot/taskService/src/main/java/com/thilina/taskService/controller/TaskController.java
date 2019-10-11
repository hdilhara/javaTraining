package com.thilina.taskService.controller;

import com.thilina.taskService.dao.Tasks;
import com.thilina.taskService.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    public TaskService taskService;

    @RequestMapping("/")
    public String rootDirectroy(){
        return "This is task root";
    }

    @RequestMapping("/ems/tasks/{pid}")
    public List<Tasks> getTaskForProject(@PathVariable Integer pid){
    return taskService.returnTasksAccordingToProject(pid);
    }
}

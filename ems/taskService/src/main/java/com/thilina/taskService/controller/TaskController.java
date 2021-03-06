package com.thilina.taskService.controller;


import com.thilina.taskService.model.Task;
import com.thilina.taskService.service.TaskService;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
   public TaskService taskService;

@RequestMapping(value = "/ems/tasks",method = RequestMethod.POST)
    public void addTask(@RequestBody Task task){
        taskService.saveTask(task);
}

@RequestMapping(value = "/ems/tasks",method = RequestMethod.GET)
    public List<Task> getTasks(){
    return taskService.getAllTasks();
}

@RequestMapping(value = "/ems/employee/project/tasks",method = RequestMethod.POST)
    public List<Task> getTasksByEidPid(@RequestBody List<Integer> tids){
       return taskService.getAllTasksByid(tids);
}

}

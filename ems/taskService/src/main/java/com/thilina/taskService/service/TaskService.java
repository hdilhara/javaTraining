package com.thilina.taskService.service;

import com.thilina.taskService.dao.Tasks;
import com.thilina.taskService.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TaskRepo taskRepo;

    public List<Tasks> getAllTasks(){
        return taskRepo.findAll();
    }
}

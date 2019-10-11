package com.thilina.taskService.service;

import com.thilina.taskService.dao.Tasks;
import com.thilina.taskService.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TaskRepo taskRepo;

    public List<Tasks> getAllTasks(){
        List<Tasks> tasks=new ArrayList<>();
        taskRepo.findAll().forEach(i->tasks.add(i));
        return tasks;
    }

    public void addTask(Tasks task){
        taskRepo.save(task);
    }
}

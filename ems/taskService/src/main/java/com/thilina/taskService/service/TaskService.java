package com.thilina.taskService.service;

import com.thilina.taskService.model.Task;
import com.thilina.taskService.repository.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TasksRepo tasksRepo;

    public void saveTask(Task task){
        tasksRepo.save(task);
    }
    public List<Task> getAllTasks(){
        List<Task> tasks=new ArrayList<>();
        tasksRepo.findAll().forEach(tasks::add);
        return tasks;
    }
    public List<Task> getAllTasksByid(List<Integer> tids){
            List<Task> tasks=new ArrayList<>();
            for (Integer i:tids){
                tasks.add(tasksRepo.findById(i).get());
            }
            return tasks;
        }

}

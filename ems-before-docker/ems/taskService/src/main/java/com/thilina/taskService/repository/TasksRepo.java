package com.thilina.taskService.repository;

import com.thilina.taskService.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepo extends CrudRepository<Task,Integer> {
}

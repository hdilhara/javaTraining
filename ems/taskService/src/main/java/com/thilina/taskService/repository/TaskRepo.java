package com.thilina.taskService.repository;

import com.thilina.taskService.dao.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<Tasks,Integer> {
}

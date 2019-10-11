package com.thilina.taskService.repository;

import com.thilina.taskService.dao.Tasks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepo extends CrudRepository<Tasks,Integer> {

    List<Tasks> findBypid(Integer pid);
}

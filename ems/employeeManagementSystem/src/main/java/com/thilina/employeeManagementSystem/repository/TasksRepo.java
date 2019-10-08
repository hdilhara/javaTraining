package com.thilina.employeeManagementSystem.repository;

import com.thilina.employeeManagementSystem.dao.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepo extends CrudRepository<Tasks,Integer> {
}

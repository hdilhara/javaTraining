package com.thilina.employeeManagementSystem.repository;

import com.thilina.employeeManagementSystem.dao.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project,Integer> {
}

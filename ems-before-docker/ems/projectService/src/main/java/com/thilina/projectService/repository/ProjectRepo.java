package com.thilina.projectService.repository;

import com.thilina.projectService.dao.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project,Integer> {

}

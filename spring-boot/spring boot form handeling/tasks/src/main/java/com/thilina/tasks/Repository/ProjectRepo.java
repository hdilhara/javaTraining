package com.thilina.tasks.Repository;

import com.thilina.tasks.model.Projects;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Projects,Integer> {
}

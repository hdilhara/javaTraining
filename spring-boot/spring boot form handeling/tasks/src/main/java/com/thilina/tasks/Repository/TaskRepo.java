package com.thilina.tasks.Repository;


import com.thilina.tasks.model.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<Tasks,Integer> {
}

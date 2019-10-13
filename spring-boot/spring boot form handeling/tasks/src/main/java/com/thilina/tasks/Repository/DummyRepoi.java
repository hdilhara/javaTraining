package com.thilina.tasks.Repository;

import com.thilina.tasks.model.Dummy;
import org.springframework.data.repository.CrudRepository;

public interface DummyRepoi extends CrudRepository<Dummy,Integer> {
}

package com.thilina.tasks.Repository;


import com.thilina.tasks.model.EPT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EPTRepo extends JpaRepository<EPT,Integer> {
    List<EPT> findByeid(Integer eid);
    List<EPT> findByEidAndPid(Integer eid,Integer pid);
}

package com.thilina.employeeManagementSystem.repository;

import com.thilina.employeeManagementSystem.dao.EPTmapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EPTrepo extends JpaRepository<EPTmapping,Integer> {
//    List<EPT> findByeid(Integer eid);
//    List<EPT> findByEidAndPid(Integer eid,Integer pid);
    List<EPTmapping> findByeid(Integer eid);
    List<EPTmapping> findByEidAndPid(Integer eid,Integer pid);
}

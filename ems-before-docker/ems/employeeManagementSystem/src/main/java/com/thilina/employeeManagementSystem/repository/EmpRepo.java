package com.thilina.employeeManagementSystem.repository;

import com.thilina.employeeManagementSystem.dao.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface EmpRepo extends CrudRepository<Employee,Integer> {
}

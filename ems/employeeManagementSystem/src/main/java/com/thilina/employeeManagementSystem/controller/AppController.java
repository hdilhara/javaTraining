package com.thilina.employeeManagementSystem.controller;

import com.thilina.employeeManagementSystem.dao.Employee;
import com.thilina.employeeManagementSystem.dao.Project;

import com.thilina.employeeManagementSystem.services.EmployeeService;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AppController {

    @Autowired
    EmployeeService empService;

    @RequestMapping("/ems")
    public String apiRootPage(){
        return "API root mapping";
    }

    /**Employee Controllers*/
    @RequestMapping("/ems/employees")
    public List<Employee> getEmployees(){
        return empService.getAllEmployees();
    }
    @RequestMapping("/ems/employees/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return empService.getEmployee(id).get();
    }
    @RequestMapping(value = "/ems/employees/employee",method = RequestMethod.POST)
    public void addEmployee(@RequestBody Employee employee){
        empService.addEmployee(employee);
    }
    @RequestMapping(value = "/ems/employees/employee/projects/{eid}",method = RequestMethod.GET)
    public List<Project> getEmployeeProjects(@PathVariable Integer eid) {
        return empService.getEmployeeProjects(eid);
    }



}

package com.thilina.employeeManagementSystem.controller;

import com.thilina.employeeManagementSystem.dao.Employee;
import com.thilina.employeeManagementSystem.dao.Project;
import com.thilina.employeeManagementSystem.dao.Tasks;
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


    /**Task controlles*/
    @RequestMapping("ems/tasks")
    public List<Tasks> getAllTasks(){
        return empService.getAllTasks();
    }
    @RequestMapping("ems/tasks/task/{id}")
    public Tasks getTask(@PathVariable Integer id){
        return empService.getTask(id).get();
    }
    @RequestMapping(value = "/ems/Tasks/Task",method = RequestMethod.POST)
    public void addTask(@RequestBody Tasks tasks)
    {
        empService.addTask(tasks);
    }
}

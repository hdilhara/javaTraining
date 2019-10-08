package com.thilina.employeeManagementSystem.services;

import com.thilina.employeeManagementSystem.dao.Employee;
import com.thilina.employeeManagementSystem.dao.Project;
import com.thilina.employeeManagementSystem.dao.Tasks;
import com.thilina.employeeManagementSystem.repository.EmpRepo;
import com.thilina.employeeManagementSystem.repository.ProjectRepo;
import com.thilina.employeeManagementSystem.repository.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmpRepo empRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    TasksRepo tasksRepo;

    /**Employee*/
    public List<Employee> getAllEmployees(){
        List<Employee> employees=new ArrayList<>();
        empRepo.findAll().forEach(employees::add);
        return employees;
    }

    public Optional<Employee> getEmployee(Integer id){
        Optional<Employee> employee=empRepo.findById(id);
        return employee;
    }

    public void addEmployee(Employee employee){
        empRepo.save(employee);
    }
    /**Projects*/
    public List<Project> getAllProjects(){
        List<Project> projects=new ArrayList<>();
        projectRepo.findAll().forEach(projects::add);
        return projects;
    }

    public Optional<Project> getProject(Integer id){
        Optional<Project> project=projectRepo.findById(id);
        return project;
    }
    public void addProject(Project project){
        projectRepo.save(project);
    }

    /**Tasks */
    public List<Tasks> getAllTasks(){
        List<Tasks> tasks=new ArrayList<>();
        tasksRepo.findAll().forEach(tasks::add);
        return tasks;
    }

    public Optional<Tasks> getTask(Integer id){
        Optional<Tasks> task=tasksRepo.findById(id);
        return task;
    }
    public void addTask(Tasks task){
        tasksRepo.save(task);
    }
}

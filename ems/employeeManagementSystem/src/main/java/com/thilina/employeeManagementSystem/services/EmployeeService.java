package com.thilina.employeeManagementSystem.services;

import com.thilina.employeeManagementSystem.config.GetToken;
import com.thilina.employeeManagementSystem.dao.EPTmapping;
import com.thilina.employeeManagementSystem.dao.Employee;
import com.thilina.employeeManagementSystem.dao.Project;

import com.thilina.employeeManagementSystem.repository.EPTrepo;
import com.thilina.employeeManagementSystem.repository.EmpRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmpRepo empRepo;
    @Autowired
    EPTrepo epTrepo;


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

    /*****mapping ****/
//    public List<Projects> getEmployeeProjects(Integer eid){
//        List<Projects> projects=new ArrayList<>();
//        List<EPT> epts=eptRepo.findByeid(eid);
//        List<Integer> pids=new ArrayList<>();
//        for(EPT ept:epts){
//            pids.add(ept.getPid());
//        }
//
//        pids = pids.stream().distinct().collect(Collectors.toList());
//        for(Integer pid:pids){
//            projects.add(projectRepo.findById(pid).get());
//
//        }
//        return projects;
//    }
    public List<Project> getEmployeeProjects(Integer eid){
        List<Project> projects=new ArrayList<>();
        List<EPTmapping> epts=epTrepo.findByeid(eid);
        List<Integer> pids=new ArrayList<>();
        for(EPTmapping e:epts){
            pids.add(e.getPid());
        }
        pids=pids.stream().distinct().collect(Collectors.toList());

        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders header=new HttpHeaders();
        header.add("Authorization","bearer"+ GetToken.getToken());
        HttpEntity<List<Integer>> request=new HttpEntity<>(pids,header);
        ResponseEntity<List<Project>> response=restTemplate.exchange("http://localhost:8383/ems/projects/findAllBypid", HttpMethod.POST, request, new ParameterizedTypeReference<List<Project>>() {
        });

        projects=response.getBody();
    return projects;
    }

}

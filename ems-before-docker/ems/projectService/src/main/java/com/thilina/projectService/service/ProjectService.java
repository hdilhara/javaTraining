package com.thilina.projectService.service;

import com.thilina.projectService.dao.Project;
import com.thilina.projectService.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

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

    public List<Project> findAllByIds(List<Integer> pids){
        List<Project> projects=new ArrayList<>();
        for (Integer i:pids){
            projects.add(projectRepo.findById(i).get());
        }
        return projects;
    }
}

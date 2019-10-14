package com.thilina.projectService;

import com.thilina.projectService.dao.Project;
import com.thilina.projectService.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/")
    public String rootMapping(){
        return "project Root";
    }

    /**Project controllers*/
    @RequestMapping("/ems/projects")
    public List<Project> getProjects(){
        return projectService.getAllProjects();
    }
    @RequestMapping("/ems/projects/project/{id}")
    public Project getProject(@PathVariable Integer id){
        return projectService.getProject(id).get();
    }
    @RequestMapping(value = "/ems/projects/project",method = RequestMethod.POST)
    public void addProject(@RequestBody Project project){
        projectService.addProject(project);
    }

    @RequestMapping(value = "/ems/projects/findAllBypid",method = RequestMethod.POST)
    public List<Project> findAllbyPid(@RequestBody List<Integer> pids){
        System.out.println(pids);
        return projectService.findAllByIds(pids);
    }
//    @RequestMapping("/ems/pids")
//    public List<Integer> getPids(){
//        List<Integer> pids= Arrays.asList(1,5,4,7);
//        return pids;
//    }
}

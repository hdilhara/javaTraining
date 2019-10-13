package com.thilina.tasks.controller;

import com.thilina.tasks.Repository.DummyRepoi;
import com.thilina.tasks.Repository.GetDateRepo;
import com.thilina.tasks.model.Dummy;
import com.thilina.tasks.model.GetDate;
import com.thilina.tasks.model.Projects;
import com.thilina.tasks.model.Tasks;
import com.thilina.tasks.servivce.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AppController {

    @Autowired
    public TaskService taskService;
    @Autowired
    public GetDateRepo getDateRepo;

    @Autowired
    public DummyRepoi dummyRepo;

    @RequestMapping("/getProjects/{eid}")
    public List<Projects> getProjects(@PathVariable Integer eid ){

        return taskService.getEmployeeProjects(eid);
    }
    @RequestMapping("/employee/project/tasks/{eid}/{pid}")
    public List<Tasks> getTasks(@PathVariable Integer eid,@PathVariable Integer pid)
    {
        return taskService.getTaskbyEidPid(eid,pid);

    }

    @RequestMapping(value = "/getDate",method = RequestMethod.POST)
    public void saveGetDate(@RequestBody GetDate getDate){

        System.out.println(getDate);
        taskService.saveGetDate(getDate);
    }
//    @RequestMapping(value = "/getDate",method = RequestMethod.POST)
//    public void saveGetDate(){
//
//        GetDate getDate=new GetDate();
//        getDate.setChoices("dfdfsg");
//        getDate.setWant("dfsfdsg");
//        getDate.setTdate(LocalDate.of(2019,11,6));
//
//
//        taskService.saveGetDate(getDate);
//    }


    @RequestMapping(value = "/getDate",method = RequestMethod.GET)
    public List<GetDate> getGetDate(GetDate getDate){
        List<GetDate> getDates=new ArrayList<>();
      for (GetDate g:getDateRepo.findAll()){
          getDates.add(g);
      }
      return getDates;
    }

    /***************************************************/



    @RequestMapping(value = "/saveDummy",method = RequestMethod.POST)
    public void saveDummy(@RequestBody Dummy dummy){
        System.out.println(dummy);
        dummyRepo.save(dummy);

    }
    @RequestMapping(value = "/getDummy")
    public List<Dummy> getDummies(){
        List<Dummy> list=new ArrayList<>();
        dummyRepo.findAll().forEach(list::add);
        System.out.println(list);
        return list;
    }
}

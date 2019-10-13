package com.thilina.tasks.servivce;


import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import com.thilina.tasks.Repository.EPTRepo;
import com.thilina.tasks.Repository.GetDateRepo;
import com.thilina.tasks.Repository.ProjectRepo;
import com.thilina.tasks.Repository.TaskRepo;
import com.thilina.tasks.model.EPT;
import com.thilina.tasks.model.GetDate;
import com.thilina.tasks.model.Projects;
import com.thilina.tasks.model.Tasks;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    public TaskRepo taskRepo;
    @Autowired
    public EPTRepo eptRepo;
    @Autowired
    public ProjectRepo projectRepo;

    @Autowired
    public GetDateRepo getDateRepo;

    public List<Projects> getEmployeeProjects(Integer eid){
        List<Projects> projects=new ArrayList<>();
       List<EPT> epts=eptRepo.findByeid(eid);
       List<Integer> pids=new ArrayList<>();
       for(EPT ept:epts){
           pids.add(ept.getPid());
       }

        pids = pids.stream().distinct().collect(Collectors.toList());
        for(Integer pid:pids){
            projects.add(projectRepo.findById(pid).get());

        }
        return projects;
    }

    public List<Tasks> getTaskbyEidPid(Integer eid,Integer pid){
        List<Tasks> tasks=new ArrayList<>();
        List<EPT> epts=eptRepo.findByEidAndPid(eid,pid);
        List<Integer> tids=new ArrayList<>();
        for(EPT a:epts){
            tids.add(a.getTid());
        }
        tids=tids.stream().distinct().collect(Collectors.toList());
        for(Integer tid:tids)
        {
            tasks.add(taskRepo.findById(tid).get());
        }
        return tasks;
    }

    public void saveGetDate(GetDate g){
        getDateRepo.save(g);
    }
}

package com.thilina.UIemployeeManagementSystem.controller;


import com.thilina.UIemployeeManagementSystem.config.GetToken;
import com.thilina.UIemployeeManagementSystem.dao.Employee;
import com.thilina.UIemployeeManagementSystem.dao.Project;

import com.thilina.UIemployeeManagementSystem.dao.Task;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sun.management.VMOptionCompositeData;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class UIController {


    @RequestMapping(value = "/")
    public String homePage(){
        return "home";
    }

    @RequestMapping(value = "/ems")
    public String emsPage() {
        return "ems";
    }




    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String employeePage(/*OAuth2Authentication auth,*/ Model model) {
        RestTemplate restTemplate=new RestTemplate();
       // final OAuth2AuthenticationDetails details=(OAuth2AuthenticationDetails)auth.getDetails();
        /**static method not to be autowired so we need @Component anotation here**/
        String token=GetToken.getToken();//details.getTokenValue();
//        model.addAttribute("token",token);

        HttpHeaders header=new HttpHeaders();/**httpenttiy we should  pass either header or body(hash map)  or both*/
        header.set("Authorization","Bearer "+token);
        HttpEntity<String> request=new HttpEntity<String>(header);
        ResponseEntity<List<Employee>> response=restTemplate.exchange("http://localhost:8282/ems/employees", HttpMethod.GET, request, new ParameterizedTypeReference<List<Employee> >() {
        });
        List<Employee> employees=response.getBody();

        model.addAttribute("emp",employees);
        return "employee";
    }

    @RequestMapping(value = "/employee" ,method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute Employee employee){
        /** Model for send the data to html--webpage @ModelAttribute for bind data from a webpage
         * @RequestBody for bind data from a request--json body
         */
        HttpHeaders header=new HttpHeaders();
        String token=GetToken.getToken();
        header.set("Authorization", "bearer"+token);

        RestTemplate restTemplate=new RestTemplate();
/**we need pass the mapping here also**/
        HashMap<String, String> mapVal= new HashMap<>();
        mapVal.put("name",employee.getName());
        mapVal.put("resignation",employee.getResignation());
/**in this http enttity we pass both body(hash map) and header**/
        HttpEntity<HashMap<String ,String>> request=new HttpEntity<>(mapVal,header);
        restTemplate.postForEntity("http://localhost:8282/ems/employees/employee/",request,String.class);

        return "redirect:/employee";/**redirect to employee**/
    }

    @GetMapping("/employee/view/{id}")
    public String getOneEmployee(@PathVariable Integer id, Model model){
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        String token=GetToken.getToken();
        headers.add("Authorization","bearer"+token);
        HttpEntity<Employee> request=new HttpEntity<>(headers);
                /**in here we dont get any response back - so we put here response type as String.class**/
        ResponseEntity<Employee> response=restTemplate.exchange("http://localhost:8282/ems/employees/employee/"+id,HttpMethod.GET,request,Employee.class);
        Employee employee=response.getBody();
        model.addAttribute("emp",employee);
        return "empView";
    }

    @RequestMapping("/projects")
    public String getProjectPage(Model model){
        HttpHeaders header=new HttpHeaders();
        String token=GetToken.getToken();
        header.add("Authorization","bearer"+token);
        RestTemplate restTemplate=new RestTemplate();
        HttpEntity<String > request=new HttpEntity<>(header);
        ResponseEntity<List<Project>> response=restTemplate.exchange("http://localhost:8383/ems/projects", HttpMethod.GET, request, new ParameterizedTypeReference<List<Project>>() {
        });
        List<Project> projects=response.getBody();
        model.addAttribute("projects",projects);
        return "projects";
    }

    @GetMapping("/projects/project/{id}")
    public String getProject(@PathVariable Integer id, Model model){
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders header=new HttpHeaders();
        String token=GetToken.getToken();
        header.add("Authorization","bearer"+token);
        HttpEntity<String> request=new HttpEntity<>(header);
        ResponseEntity<Project> response=restTemplate.exchange("http://localhost:8383/ems/projects/project/"+id,HttpMethod.GET,request,Project.class);
        Project project=response.getBody();
        model.addAttribute("project",project);

        return "proView";

    }

    @RequestMapping(value ="/projects/project",method = RequestMethod.POST)
    public String addProject(@ModelAttribute Project project){
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders header=new HttpHeaders();
        String token=GetToken.getToken();
        header.add("Authorization","bearer"+token);
        HashMap<String,String> mapVal=new HashMap<>();
        mapVal.put("pname",project.getPname());
        mapVal.put("country",project.getCountry());
        mapVal.put("tech",project.getTech());
        HttpEntity<HashMap<String,String>> request=new HttpEntity<>(mapVal,header);
        restTemplate.postForEntity("http://localhost:8383/ems/projects/project",request,String.class);

        return "redirect:/projects";

    }

    /*Controller for Tasks*/
    @GetMapping("/tasks")
    public String getTasksPage(Model model){
        HttpHeaders header=new HttpHeaders();
        header.add("Authorization","bearer"+GetToken.getToken());
        HttpEntity<String> request=new HttpEntity<>(header);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<List<Task>> response=restTemplate.exchange("http://localhost:8484/ems/tasks", HttpMethod.GET, request, new ParameterizedTypeReference<List<Task>>() {
        });
        List<Task> tasks=response.getBody();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @RequestMapping(value = "/tasks",method = RequestMethod.POST)
    public String addTask(@ModelAttribute Task task){
        HttpHeaders header=new HttpHeaders();
        header.add("Authorization","bearer"+GetToken.getToken());
        HttpEntity<Task> request=new HttpEntity<>(task,header);
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.exchange("http://localhost:8484/ems/tasks",HttpMethod.POST,request,String.class);
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/employees/employee/projects/{eid}",method = RequestMethod.GET)
    public String getEmployeeProjects(@PathVariable Integer eid, Model model){
        List<Project> projects=new ArrayList<>();
        HttpHeaders header=new HttpHeaders();
        header.add("Authorization","bearer"+GetToken.getToken());
        HttpEntity<String> request=new HttpEntity<>(header);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<List<Project>> response=restTemplate.exchange("http://localhost:8282/ems/employees/employee/projects/" + eid, HttpMethod.GET, request, new ParameterizedTypeReference<List<Project>>() {
        });
        projects=response.getBody();
        model.addAttribute("projects",projects);
        model.addAttribute("eid",eid);
        return "employeeProjects";
    }

    @RequestMapping(value = "/ems/employee/project/tasks/{eid}/{pid}",method = RequestMethod.GET)
    public String getEmployeeProjectTasks(@PathVariable Integer eid,@PathVariable Integer pid, Model model){
        List<Task> tasks=new ArrayList<>();
        HttpHeaders header=new HttpHeaders();
        List<Integer> tids=new ArrayList<>();
        header.add("Authorization","bearer"+GetToken.getToken());
        HttpEntity<String> request=new HttpEntity<>(header);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<List<Task>> response=restTemplate.exchange("http://localhost:8282/ems/employees/employee/projects/tasks/"+ eid+"/"+pid, HttpMethod.GET, request, new ParameterizedTypeReference<List<Task>>() {
        });
        tasks=response.getBody();
        model.addAttribute("tasks",tasks);
        return "empProTasks";
    }

    /*****Operations**********/
    @GetMapping("/operations")
    public String getOperationPage(Model model){
        HttpHeaders header=new HttpHeaders();
        header.add("Authorization","bearer "+GetToken.getToken());

        RestTemplate restTemplate=new RestTemplate();


        List<Project> projects=new ArrayList<>();
        List<Employee> employees=new ArrayList<>();
        List<Task> tasks=new ArrayList<>();
        /**get all emploies**/
        HttpEntity<String> requestEmploies=new HttpEntity<String>(header);
        ResponseEntity<List<Employee>> responseEmploies=restTemplate.exchange("http://localhost:8282/ems/employees", HttpMethod.GET, requestEmploies, new ParameterizedTypeReference<List<Employee> >() {
        });

        /**get all projects**/
        HttpEntity<String > requestProject=new HttpEntity<>(header);
        ResponseEntity<List<Project>> responseProjects=restTemplate.exchange("http://localhost:8383/ems/projects", HttpMethod.GET, requestProject, new ParameterizedTypeReference<List<Project>>() {
        });

        /**get all tasks**/
        HttpEntity<String> requestTask=new HttpEntity<>(header);
        ResponseEntity<List<Task>> responseTask=restTemplate.exchange("http://localhost:8484/ems/tasks", HttpMethod.GET, requestTask, new ParameterizedTypeReference<List<Task>>() {
        });

        projects=responseProjects.getBody();
        model.addAttribute("projects",projects);
        employees=responseEmploies.getBody();
        model.addAttribute("employees",employees);
        tasks=responseTask.getBody();
        model.addAttribute("tasks",tasks);
        return "operations";
    }

    @RequestMapping(value = "/operations",method = RequestMethod.POST)
    public String executeOperation(@ModelAttribute ){


        return "redirect:/operations";
    }
}

package com.thilina.UIemployeeManagementSystem.controller;

import com.sun.deploy.net.HttpResponse;
import com.thilina.UIemployeeManagementSystem.config.GetToken;
import com.thilina.UIemployeeManagementSystem.dao.Employee;
import com.thilina.UIemployeeManagementSystem.dao.Project;

import com.thilina.UIemployeeManagementSystem.dao.Tasks;
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

import javax.jws.WebParam;
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
    @RequestMapping("/tasks")
    public String getTasksPage(Model model){

        HttpHeaders headers =new HttpHeaders();
        headers.add("Authorization","bearer"+GetToken.getToken());
        HttpEntity<String> request=new HttpEntity<>(headers);

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<List<Tasks>> response=restTemplate.exchange("http://localhost:8484/ems/tasks", HttpMethod.GET, request, new ParameterizedTypeReference<List<Tasks>>() {
        });
        List<Tasks> tasks=response.getBody();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

}

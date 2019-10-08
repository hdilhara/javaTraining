package com.thilina.UIemployeeManagementSystem.controller;

import com.thilina.UIemployeeManagementSystem.dao.Employee;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.jws.WebParam;
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

    @RequestMapping(value = "/employee")
    public String employeePage(OAuth2Authentication auth, Model model) {
        RestTemplate restTemplate=new RestTemplate();
        final OAuth2AuthenticationDetails details=(OAuth2AuthenticationDetails)auth.getDetails();
       String token=details.getTokenValue();
//        model.addAttribute("token",token);

        HttpHeaders header=new HttpHeaders();
        header.set("Authorization","Bearer "+token);
        HttpEntity<String> request=new HttpEntity<String>(header);
        ResponseEntity<List<Employee>> response=restTemplate.exchange("http://localhost:8282/ems/employees", HttpMethod.GET, request, new ParameterizedTypeReference<List<Employee> >() {
        });
        List<Employee> employees=response.getBody();

        model.addAttribute("emp",employees);




        return "employee";
    }
}

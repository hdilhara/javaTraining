package com.thilina.springdatajpaexample;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class StudentController {


    @RequestMapping("/hello")
    public String greeting(){
        return "hello Springboot";
    }
}

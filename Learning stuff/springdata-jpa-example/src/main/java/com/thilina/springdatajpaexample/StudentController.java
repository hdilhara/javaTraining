package com.thilina.springdatajpaexample;


import com.thilina.springdatajpaexample.model.Address;
import com.thilina.springdatajpaexample.model.Student;
import com.thilina.springdatajpaexample.model.Telephone;
import com.thilina.springdatajpaexample.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sms")
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;

    @RequestMapping("/hello")
    public String greeting(){
        return "hello Springboot";
    }

//    @RequestMapping(value="/students",method = RequestMethod.GET)
//    public Student getStudent(){
//        Student student=new Student();
//        student.setName("Thilina");
//
//        Address address=new Address();
//        address.setCity("Kiribathgoda");
//
//        student.setAddress(address);
//
//        List<Telephone> telephones=new ArrayList<>();
//        Telephone telephone=new Telephone();
//
//        telephone.setNumber("202788882");
//        telephones.add(telephone);
//
//        student.setTelephones(telephones);
//
//        telephone.setStudent(student);
//        return student;
//    }



    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student){
        studentServiceImpl.save(student);
        return student;
    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> getStudents(){
        return studentServiceImpl.getStudents();
    }

    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public Optional<Student> getStudent(@PathVariable Integer id){
        return studentServiceImpl.getStudent(id);
    }



}

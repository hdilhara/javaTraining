package com.thilina.springdatajpaexample.service;

import com.thilina.springdatajpaexample.model.Student;
import com.thilina.springdatajpaexample.model.Telephone;
import com.thilina.springdatajpaexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {

    @Autowired
    StudentRepository studentRepository;

    public Student save(Student student){
        for(Telephone telephone: student.getTelephones()){
            telephone.setStudent(student);
        }
        studentRepository.save(student);

        return student;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(Integer id){
        return studentRepository.findById(id);
    }

}

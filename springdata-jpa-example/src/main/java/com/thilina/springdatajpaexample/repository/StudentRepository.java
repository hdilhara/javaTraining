package com.thilina.springdatajpaexample.repository;

import com.thilina.springdatajpaexample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}

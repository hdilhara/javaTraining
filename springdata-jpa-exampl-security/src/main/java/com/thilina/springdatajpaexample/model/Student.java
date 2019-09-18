package com.thilina.springdatajpaexample.model;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//U
    private Integer sid;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    Address address ;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    List<Telephone> telephones;

    @ManyToMany
    @JoinTable(name = "student_projects",
            joinColumns = @JoinColumn(name = "sid",referencedColumnName = "sid"),
            inverseJoinColumns = @JoinColumn(name = "pid",referencedColumnName = "pid"))
    List<Project> projects;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

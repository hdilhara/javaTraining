package com.thilina.UIemployeeManagementSystem.dao;

public class Project {
    private Integer pid;
    private String pname;
    private String tech;
    private String country;

    public Project() {
    }

    public Project(Integer pid, String pname, String tech, String country) {
        this.pid = pid;
        this.pname = pname;
        this.tech = tech;
        this.country = country;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

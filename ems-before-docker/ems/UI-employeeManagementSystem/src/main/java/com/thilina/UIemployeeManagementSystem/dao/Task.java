package com.thilina.UIemployeeManagementSystem.dao;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Task {

    private Integer tid;
    private String tname;
    private String tdesc;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tdate;


    public Task() {
    }

    public Task(Integer tid, String tname, String tdesc, LocalDate tdate) {
        this.tid = tid;
        this.tname = tname;
        this.tdesc = tdesc;
        this.tdate = tdate;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTdesc() {
        return tdesc;
    }

    public void setTdesc(String tdesc) {
        this.tdesc = tdesc;
    }

    public LocalDate getTdate() {
        return tdate;
    }

    public void setTdate(LocalDate tdate) {
        this.tdate = tdate;
    }
}

package com.thilina.taskService.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    private String tname;
    private String tdesd;
    private String tdate;

    public Tasks() {
    }

    public Tasks(Integer tid, String tname, String tdesd, String tdate) {
        this.tid = tid;
        this.tname = tname;
        this.tdesd = tdesd;
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

    public String getTdesd() {
        return tdesd;
    }

    public void setTdesd(String tdesd) {
        this.tdesd = tdesd;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }
}


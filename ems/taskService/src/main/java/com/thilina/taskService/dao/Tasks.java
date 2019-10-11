package com.thilina.taskService.dao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tasks {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer tid;
    private String tname;
    private String desc;
    private String date;

    public Tasks() {
    }

    public Tasks(Integer tid, String tname, String desc, String date) {
        this.tid = tid;
        this.tname = tname;
        this.desc = desc;
        this.date = date;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package com.thilina.UIemployeeManagementSystem.dao;

public class Tasks {
    private Integer tid;
    private String tname;
    private String tdesc;
    private String tdate;

    public Tasks() {
    }

    public Tasks(Integer tid, String tname, String tdesc, String tdate) {
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

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }
}

package com.thilina.employeeManagementSystem.dao;

public class EidPid {
    private Integer eid;
    private Integer pid;

    public EidPid() {
    }

    public EidPid(Integer eid, Integer pid) {
        this.eid = eid;
        this.pid = pid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}

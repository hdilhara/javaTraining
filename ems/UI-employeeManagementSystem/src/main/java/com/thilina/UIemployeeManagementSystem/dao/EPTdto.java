package com.thilina.UIemployeeManagementSystem.dao;

public class EPTdto {
    Integer eid;
    Integer pid;
    Integer[] tids;

    public EPTdto() {
    }

    public EPTdto(Integer eid, Integer pid, Integer[] tids) {
        this.eid = eid;
        this.pid = pid;
        this.tids = tids;
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

    public Integer[] getTids() {
        return tids;
    }

    public void setTids(Integer[] tids) {
        this.tids = tids;
    }
}

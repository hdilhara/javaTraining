package com.thilina.employeeManagementSystem.dao;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EPTmapping {

        @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer eptid;
        Integer eid;
        Integer pid;
        Integer tid;

    public EPTmapping() {
    }

    public EPTmapping(Integer eptid, Integer eid, Integer pid, Integer tid) {
        this.eptid = eptid;
        this.eid = eid;
        this.pid = pid;
        this.tid = tid;
    }

    public Integer getEptid() {
        return eptid;
    }

    public void setEptid(Integer eptid) {
        this.eptid = eptid;
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

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}

package com.thilina.employeeManagementSystem.dao;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EmpProTask {

    @EmbeddedId
    private EmpProject_Compkey eptID;

    private Integer tID;

    public EmpProTask() {
    }

    public EmpProTask(EmpProject_Compkey eptID, Integer tID) {
        this.eptID = eptID;
        this.tID = tID;
    }

    public EmpProject_Compkey getEptID() {
        return eptID;
    }

    public void setEptID(EmpProject_Compkey eptID) {
        this.eptID = eptID;
    }

    public Integer gettID() {
        return tID;
    }

    public void settID(Integer tID) {
        this.tID = tID;
    }
}

package com.thilina.employeeManagementSystem.dao;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmpProject_Compkey implements Serializable {

    private Integer empId;

    private Integer coId;

    public EmpProject_Compkey() {
    }

    public EmpProject_Compkey(Integer empId, Integer coId) {
        this.empId = empId;
        this.coId = coId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getCoId() {
        return coId;
    }

    public void setCoId(Integer coId) {
        this.coId = coId;
    }
}

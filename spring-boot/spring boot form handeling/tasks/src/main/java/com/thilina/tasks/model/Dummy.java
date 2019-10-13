package com.thilina.tasks.model;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
public class Dummy {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate ddate;

    String dropDown;
    String[] choices;




    public Dummy() {
    }

    public Dummy(Integer id, String name, LocalDate ddate, String dropDown, String[] choices) {
        this.id = id;
        this.name = name;
        this.ddate = ddate;
        this.dropDown = dropDown;
        this.choices = choices;
    }

    public String getDropDown() {
        return dropDown;
    }

    public void setDropDown(String dropDown) {
        this.dropDown = dropDown;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ddate=" + ddate +
                ", dropDown='" + dropDown + '\'' +
                ", choices=" + Arrays.toString(choices) +
                '}';
    }

    public LocalDate getDdate() {
        return ddate;
    }

    public void setDdate(LocalDate ddate) {
        this.ddate = ddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

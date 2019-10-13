package com.thilina.UIdemoDTO.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Arrays;

public class Dummy {

    Integer id;
    String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate ddate;
    String dropDown;
    String[] choices;

    public Dummy(Integer id, String name, LocalDate ddate, String dropDown, String[] choices) {
        this.id = id;
        this.name = name;
        this.ddate = ddate;
        this.dropDown = dropDown;
        this.choices = choices;
    }

    public Dummy() {
    }

    public String getDropDown() {
        return dropDown;
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

    public void setDropDown(String dropDown) {
        this.dropDown = dropDown;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
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

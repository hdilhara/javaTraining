package com.thilina.UIdemoDTO.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class GetDateModel {

    Integer gid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate tdate;

    String choices;

    String want;

    public GetDateModel() {
    }

    public GetDateModel(Integer gid, LocalDate tdate, String choices, String want) {
        this.gid = gid;
        this.tdate = tdate;
        this.choices = choices;
        this.want = want;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public LocalDate getTdate() {
        return tdate;
    }

    public void setTdate(LocalDate tdate) {
        this.tdate = tdate;
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }

    @Override
    public String toString() {
        return "GetDateModel{" +
                "gid=" + gid +
                ", tdate=" + tdate +
                ", choices='" + choices + '\'' +
                ", want='" + want + '\'' +
                '}';
    }
}

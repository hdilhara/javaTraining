package com.thilina.tasks.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class GetDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer gid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate tdate;

    String choices;

    String want;

    public GetDate() {
    }

    public GetDate(Integer gid, LocalDate tdate, String choices, String want) {
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
        return "GetDate{" +
                "gid=" + gid +
                ", tdate=" + tdate +
                ", choices='" + choices + '\'' +
                ", want='" + want + '\'' +
                '}';
    }
}

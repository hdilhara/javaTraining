package com.thilina.UIdemoDTO.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class GetDate {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate tdate;

    String choices;

    String[] want;

    public GetDate() {
    }

    public GetDate(LocalDate tdate, String choices, String[] want) {
        this.tdate = tdate;
        this.choices = choices;
        this.want = want;
    }

    public String[] getWant() {
        return want;
    }

    public void setWant(String[] want) {
        this.want = want;
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
}

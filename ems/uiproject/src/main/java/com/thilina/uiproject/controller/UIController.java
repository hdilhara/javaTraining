package com.thilina.uiproject.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class UIController extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
    }

    @RequestMapping(value = "/")
    public String displayHome(){
        return "home";
    }

    @RequestMapping(value = "/addStudent")
    public String addStudent(){
        return "save";
    }

    @RequestMapping(value = "/fetchStudent")
    public String fetchStudent(){
        return "fetchStudent";
    }

    @RequestMapping(value = "/fetchAll")
    public String fetchAll(){
        return "fetchAll";
    }

    @RequestMapping(value = "/updateStudent")
    public String updateStudent(){
        return "updateStudent";
    }
}

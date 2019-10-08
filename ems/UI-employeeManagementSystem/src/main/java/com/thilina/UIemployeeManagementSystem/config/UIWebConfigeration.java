package com.thilina.UIemployeeManagementSystem.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@EnableOAuth2Sso /**this shoud be applied here*/
public class UIWebConfigeration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/","/img/**").permitAll()
                .antMatchers("/ems/**").authenticated()
                .anyRequest().authenticated();
    }

//    @RequestMapping(value = "/")
//    public String homePage(){
//        return "home";
//    }
//
//    @RequestMapping(value = "/ems")
//    public String emsPage(){
//        return "ems";
//    }
}

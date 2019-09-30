package com.thilina.todoApp.controller;

import com.thilina.todoApp.model.User;
import com.thilina.todoApp.service.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    ValidateUser validateUser;

    @RequestMapping("/")
    public String homePage(){
        return "home";
    }


    @RequestMapping("/login")
    public String login(@RequestParam String uname,@RequestParam String upass){
        User user=new User(uname,upass);
        if(validateUser.validateUser(user))
        {
            return "logedin";
        }
        else
            return "home";

    }

    @RequestMapping("/todoList")
    public String todoList(){
        return "todoList";
    }
}

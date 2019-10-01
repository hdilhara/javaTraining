package com.thilina.todoApp.controller;

import com.thilina.todoApp.model.User;
import com.thilina.todoApp.service.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("uname")
public class TodoController {

    @Autowired
    ValidateUser validateUser;

    @RequestMapping("/")
    public String homePage(){
        return "home";
    }


    @RequestMapping("/login")
    public String login(User user){
        String uname=user.getUname();
        ModelMap mm=new ModelMap();
        mm.put("uname",uname);
       // User user=new User(user.getUname(),user.getUpass());
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

package com.thilina.todoApp.service;

import com.thilina.todoApp.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateUser {


    public boolean validateUser(User user){
        //boolean validUser=false;
        Optional<User> user1=User.userList.stream().filter(i->i.getUname().equalsIgnoreCase(user.getUname()) && i.getUpass().equalsIgnoreCase(user.getUpass())).findFirst();
        if(user1.isPresent())
            return true;
        else
            return false;
    }
}

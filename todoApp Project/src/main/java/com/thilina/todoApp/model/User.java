package com.thilina.todoApp.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String uname;
    private String upass;

    static  String name="dfdfsd";

    public static List<User> userList = new ArrayList<>();

    static {


        userList.add(new User("Thilina","1234"));
        userList.add(new User("virtusa","1234"));

    }

    public User(String uname, String upass) {
        this.uname = uname;
        this.upass = upass;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public static List<User> getUserList() {
        return userList;
    }

    public static void setUserList(List<User> userList) {
        User.userList = userList;
    }
}



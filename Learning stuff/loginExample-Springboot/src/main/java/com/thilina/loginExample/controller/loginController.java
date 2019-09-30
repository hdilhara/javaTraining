package com.thilina.loginExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thilina.loginExample.servise.LoginServise;

@Controller
public class loginController {
	
	@Autowired
	LoginServise serviseValidate;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage() {
		return "logme";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String welcomePage(@RequestParam String uname,@RequestParam String password,ModelMap model) {
		model.put("m1", uname);
		
		if (serviseValidate.validateMe(uname, password))
		return "welcome";
		
		else
			return "logme";
	}

}

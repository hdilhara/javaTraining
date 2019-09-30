package com.thilina.loginExample.servise;

import org.springframework.stereotype.Service;

@Service
public class LoginServise {
	
	public boolean validateMe(String uname,String password) {
		if (uname.equalsIgnoreCase("thilina")&& password.equalsIgnoreCase("1234"))
			return true;
		else
			return false;
	}
}

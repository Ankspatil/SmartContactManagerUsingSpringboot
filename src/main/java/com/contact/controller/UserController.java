package com.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
 	@RequestMapping("/index")
 	public String dashboard()
 	{
 	   return "normal/user_dashboard";
 	   
 	}

}

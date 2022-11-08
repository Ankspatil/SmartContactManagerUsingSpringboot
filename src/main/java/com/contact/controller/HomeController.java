package com.contact.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.contact.doa.UserRepository;
import com.contact.entities.User;
import com.contact.helper.Massage;


@Controller
public class HomeController {
      
	
	
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
	private BCryptPasswordEncoder passwordEncoder;
	
	
	
     @Autowired
	private UserRepository userRepo ;
	

 	@RequestMapping("/")
 	public String home( Model model)
 	{
 		model.addAttribute("title" , "Home-Smart contact Manager");
 		return "home";
 	}
 	
 	@RequestMapping("/signup")
 	public String signup( Model model)
 	{
 		model.addAttribute("title" , "SignUp-Smart contact Manager");
 		model.addAttribute("user",new User());
 		
 		
 		return "signup";
 	}
 	
 	@RequestMapping(value="/do_ragister", method = RequestMethod.POST)
 	public String ragisterUser(@ModelAttribute("user") User user ,
 			@RequestParam(value ="agrrement" ,defaultValue =  "false")
 	boolean agreement , Model model, HttpSession session)
 	{
 try {     
	 
		if(!agreement)
	  	{
	 			System.out.println("not accept terms and conditions");
	 			throw new Exception("not accept terms and conditions");
		}
	 		user.setRole("Role_User");
	 		user.setEnable(true);
	 		//user.setPassword(passwordEncoder.encode(user.getPassword()));
	 		user.setPassword(passwordEncoder.encode(user.getPassword()));
	 		
	 		System.out.println(agreement);
	 		System.out.println(user);
	 		
	 	User result =	this.userRepo.save(user);
	 		model.addAttribute("user",result);
	 		
	 		model.addAttribute("user",new User());
	 		session.setAttribute("massege", new Massage("Successfully Registered..!!" , "alert-success"));
	 	
	 		return "signup";
	
     }
 
 catch (Exception e) {
	model.addAttribute("user",new User());
	session.setAttribute("massege", new Massage("Someting went wrong..!!"  + e.getMessage() , "alert-denger"));
     return "signup";
 
 }
 	}
	
	
	
	
}
	
	
	
	
	
	

	
	
	
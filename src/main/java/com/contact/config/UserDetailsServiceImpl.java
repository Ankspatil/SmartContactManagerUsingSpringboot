package com.contact.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.doa.UserRepository;
import com.smart.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {
 
	@Autowired
	private UserRepository  userrepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	         
		//fatching user from database
		User user =userrepo.getUserbyName(username);
		
		if(user == null)
		{
			throw new UsernameNotFoundException("could not found user...!!!");
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails(user); 
		
		return customUserDetails;
	}

}

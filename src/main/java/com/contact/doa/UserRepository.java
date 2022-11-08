package com.contact.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.entities.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query("select u from User u.email =: email")
	public User getUserbyName(@Param("email")String email);


	
	

}

package com.testapp.service;

import java.util.List;

import com.testapp.entity.User;
import com.testapp.exceptions.ResourceNotFoundException;

public interface UserService {

	// add user

	String addUser(User u);

	// update user
	User updateUser(User u, Long userId) throws ResourceNotFoundException;

	//
	User assignTest(Long userId, Long testId) throws ResourceNotFoundException;
	
	User authenticate(String userName,String userPassword) throws Exception;
	
	List<User> getALl();

}

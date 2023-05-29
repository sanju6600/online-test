package com.testapp.service;

import java.util.List;

import com.testapp.entity.Test;
import com.testapp.exceptions.ResourceNotFoundException;

public interface TestService {
	
	//add test
	
	Test addTest(Test test);
	
	//update test
	
	Test updateTest(Test test) throws ResourceNotFoundException;
	
	//delete test

	boolean deleteTest(Long testId) throws ResourceNotFoundException;
	//get all tests 
	
	List<Test> getAllTest();
	
	//get test by test name
	

}

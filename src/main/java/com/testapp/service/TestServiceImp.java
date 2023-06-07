package com.testapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testapp.dao.TestDao;
import com.testapp.entity.Test;
import com.testapp.exceptions.ResourceNotFoundException;

@Service
public class TestServiceImp implements TestService {

	@Autowired
	private TestDao testDao; // dependency injection

	@Override
	public Test addTest(Test test) {

		return testDao.save(test);
	}

	@Override
	public Test updateTest(Test test) throws ResourceNotFoundException {
		Test t = testDao.findById(test.getTestId()).orElseThrow(() -> new ResourceNotFoundException(
				"Requested Test with Id : " + test.getTestId() + " Doesn't Exists"));
		test.setTestQustions(null);
		test.setCurrentQuestion(null);
		testDao.delete(t);
		test.setTestQustions(t.getTestQustions());
		test.setCurrentQuestion(t.getCurrentQuestion());
		return testDao.save(test);
	}

	@Override
	public boolean deleteTest(Long testId) throws ResourceNotFoundException {
		Test t = testDao.findById(testId).orElseThrow(
				() -> new ResourceNotFoundException("Requested Test with Id : " + testId + " Doesn't Exists"));
		t.setTestQustions(null);
		t.setCurrentQuestion(null);
		testDao.delete(t);

		return true;
	}

	@Override
	public List<Test> getAllTest() {

		return testDao.findAll();
	}

	@Override
	public Test getById(Long testLongId) throws ResourceNotFoundException {
		
		return testDao.findById(testLongId).orElseThrow(
				() -> new ResourceNotFoundException("Requested Test with Id : " + testLongId + " Doesn't Exists"));
	}

}

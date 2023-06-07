package com.testapp.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testapp.dao.QuestionDao;
import com.testapp.dao.TestDao;
import com.testapp.entity.Question;
import com.testapp.entity.Test;
import com.testapp.exceptions.ResourceNotFoundException;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	@Autowired
	private TestDao testDao;

	@Override
	public String addQuestion(Question question, Long testId) throws ResourceNotFoundException {
		Test t = testDao.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Test Not Found"));
		Set<Question> queList = (Set<Question>) questionDao.findAll();
		queList.add(question);
		t.setTestQustions(queList);
		testDao.save(t);
		return "Question added successfully";
	}

	@Override
	public String updateQuestion(Question question, Long testId, Long qId) throws ResourceNotFoundException {

		Test t = testDao.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Test Not Found"));

		Question q = questionDao.findById(qId)
				.orElseThrow(() -> new ResourceNotFoundException("Question not Found with Id :" + qId));
		questionDao.delete(q);
		Set<Question> queList = (Set<Question>) questionDao.findAll();
		queList.add(question);
		t.setTestQustions(queList);
		testDao.save(t);

		return "Question Updated In the Test ";
	}

	@Override
	public boolean deleteQuestion(Long id) throws ResourceNotFoundException {
		Question q = questionDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question Not Found "));
		questionDao.delete(q);
		return true;
	}
	

}

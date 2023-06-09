package com.testapp.service;

import java.util.List;
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
		List<Question> q=t.getTestQustions();
		q.add(question);
		t.setTestQustions(q);
		testDao.save(t);
		return "Question added successfully";
	}

	@Override
	public String updateQuestion(Question question, Long testId, Long qId) throws ResourceNotFoundException {

		Test t = testDao.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Test Not Found"));
		List<Question> queList = t.getTestQustions();
		for (int i = 0; i < queList.size(); i++) {
			if (queList.get(i).getQuestionId() == qId) {
				questionDao.delete(queList.get(i));
				queList.remove(i);
				queList.add(question);
			}
		}
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

	@Override
	public List<Question> getQuestions(Long testId) throws ResourceNotFoundException {
		Test t=testDao.findById(testId).orElseThrow(()->new ResourceNotFoundException("Test Not Found"));
		return t.getTestQustions();
	}

	@Override
	public Question getQuestionById(Long id) throws ResourceNotFoundException {
		return questionDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Question doesn't exists")) ;
	}

}

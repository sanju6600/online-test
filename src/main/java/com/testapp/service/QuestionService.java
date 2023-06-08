package com.testapp.service;

import java.util.List;

import com.testapp.entity.Question;
import com.testapp.exceptions.ResourceNotFoundException;

public interface QuestionService {
	
	String addQuestion(Question question,Long testId) throws ResourceNotFoundException;
	
	public String updateQuestion(Question question, Long testId,Long qId) throws ResourceNotFoundException;
	
	boolean deleteQuestion(Long id) throws ResourceNotFoundException;
	
	public List<Question> getQuestions(Long testId) throws ResourceNotFoundException;
	
	public Question getQuestionById(Long id) throws ResourceNotFoundException;
	

}

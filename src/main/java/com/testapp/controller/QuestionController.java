package com.testapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.testapp.entity.Question;
import com.testapp.exceptions.ResourceNotFoundException;
import com.testapp.service.QuestionService;

@CrossOrigin
@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@PostMapping("/add/{testId}")
	public ResponseEntity<?> addTest(@RequestBody Question question, @PathVariable Long testId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(questionService.addQuestion(question, testId), HttpStatus.CREATED);
	}

	@PutMapping("/update/{testId}/{qId}")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question, @PathVariable Long testId,
			@PathVariable Long qId) throws ResourceNotFoundException {
		return new ResponseEntity<>(questionService.updateQuestion(question, testId, qId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
		return new ResponseEntity<>(questionService.deleteQuestion(id), HttpStatus.OK);
	}

	@GetMapping("/all/{id}")
	public ResponseEntity<?> getQuestionsOfTest(@PathVariable Long id) throws ResourceNotFoundException {
		return new ResponseEntity<>(questionService.getQuestions(id), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) throws ResourceNotFoundException {
		return new ResponseEntity<>(questionService.getQuestionById(id), HttpStatus.OK);
	}
}

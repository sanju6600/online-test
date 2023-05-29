package com.testapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testapp.entity.Test;
import com.testapp.exceptions.ResourceNotFoundException;
import com.testapp.service.TestService;

@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	private TestService testService;

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Test test) {
		return new ResponseEntity<>(testService.addTest(test), HttpStatus.CREATED); // http status code 201
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllTest() {
		return new ResponseEntity<>(testService.getAllTest(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
		return new ResponseEntity<>(testService.deleteTest(id), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Test test) throws ResourceNotFoundException {
		return new ResponseEntity<>(testService.updateTest(test), HttpStatus.OK);
	}

}

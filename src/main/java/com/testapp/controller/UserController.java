package com.testapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testapp.entity.User;
import com.testapp.exceptions.ResourceNotFoundException;
import com.testapp.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User u) {
		return new ResponseEntity<>(service.addUser(u), HttpStatus.CREATED);

	}

	@PutMapping("/update/{uid}")
	public ResponseEntity<?> update(@RequestBody User u, @PathVariable Long uid) throws ResourceNotFoundException {
		return new ResponseEntity<>(service.updateUser(u, uid), HttpStatus.OK);
	}

	@GetMapping("/{uId}/{tId}")
	public ResponseEntity<?> assignTest(@PathVariable Long uId, @PathVariable Long tId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(service.assignTest(uId, tId), HttpStatus.OK);
	}

	@GetMapping("/login/{id}/{pass}")
	public ResponseEntity<?> login(@PathVariable String id, @PathVariable String pass) throws Exception {
		return new ResponseEntity<>(service.authenticate(id, pass), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(service.getALl(), HttpStatus.OK);
	}

}

package com.testapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testapp.dao.TestDao;
import com.testapp.dao.UserDao;
import com.testapp.entity.Test;
import com.testapp.entity.User;
import com.testapp.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TestDao testDao;

	@Autowired
	private UserDao userDao;

	@Override
	public String addUser(User u) {

		userDao.save(u);

		return "User Added ";
	}

	@Override
	public User updateUser(User u, Long userId) throws ResourceNotFoundException {
		User user = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Desn't exists"));
		userDao.delete(user);
		u.setTest(user.getTest());
		u.setUserPassword(user.getUserPassword());
		return userDao.save(u);
	}

	@Override
	public User assignTest(Long userId, Long testId) throws ResourceNotFoundException {
		Test t = testDao.findById(testId)
				.orElseThrow(() -> new ResourceNotFoundException("Test Not Found with Id : " + testId));
		User u = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Deosn't exists with id :" + userId));
		u.setTest(t);
		return userDao.save(u);
	}

	@Override
	public User authenticate(String userName, String userPassword) throws Exception {
		Optional<User> u = userDao.authenticateUser(userName, userPassword);
		System.out.println("Hiii");
		if (u.isEmpty()) {
			throw new Exception("Invalid Crendentials");
		}
		return u.get();
	}

	@Override
	public List<User> getALl() {

		return userDao.findAll();
	}

}

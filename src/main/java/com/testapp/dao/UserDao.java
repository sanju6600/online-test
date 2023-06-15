package com.testapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testapp.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	@Query("select c from User c where c.userName=?1 And c.userPassword=?2")
	Optional< User > authenticateUser(String userName,String userPassword);

}


package com.testapp.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testapp.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {

}

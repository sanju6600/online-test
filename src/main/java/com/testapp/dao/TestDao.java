package com.testapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testapp.entity.Test;

@Repository
public interface TestDao extends JpaRepository<Test, Long> {

}

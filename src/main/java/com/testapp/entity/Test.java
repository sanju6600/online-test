package com.testapp.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "test_table")
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long testId;

	private String testTitle;

	
	@JsonFormat(pattern="HH:mm")
	private LocalTime testDuration;

	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name ="question_fk")
	private Set<Question> testQustions;

	private BigDecimal testTotalMarks;

	private double testMarksScored;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "currentQuestion_fk",referencedColumnName = "questionId")
	private Question currentQuestion;

	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime startTime;

//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime endTime;


	public Long getTestId() {
		return testId;
	}


	public void setTestId(Long testId) {
		this.testId = testId;
	}


	public String getTestTitle() {
		return testTitle;
	}


	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}


	public LocalTime getTestDuration() {
		return testDuration;
	}


	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}


	public Set<Question> getTestQustions() {
		return testQustions;
	}


	public void setTestQustions(Set<Question> testQustions) {
		this.testQustions = testQustions;
	}


	public BigDecimal getTestTotalMarks() {
		return testTotalMarks;
	}


	public void setTestTotalMarks(BigDecimal testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}


	public double getTestMarksScored() {
		return testMarksScored;
	}


	public void setTestMarksScored(double testMarksScored) {
		this.testMarksScored = testMarksScored;
	}


	public Question getCurrentQuestion() {
		return currentQuestion;
	}


	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}


	public Test(Long testId, String testTitle, LocalTime testDuration, Set<Question> testQustions,
			BigDecimal testTotalMarks, double testMarksScored, Question currentQuestion, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testQustions = testQustions;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		this.currentQuestion = currentQuestion;
		this.startTime = startTime;
		this.endTime = endTime;
	}


	public Test() {
		super();
	}

}

package com.testapp.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger questionId;
	
	private List<String> questionOptions;
	private String quesionTitle;
	private int questionAnswer;
	private double questionMarks;
	private  int chosenAnswer;
	private double MarksScored;
	public BigInteger getQuestionId() {
		return questionId;
	}
	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}
	public List<String> getQuestionOptions() {
		return questionOptions;
	}
	public void setQuestionOptions(List<String> questionOptions) {
		this.questionOptions = questionOptions;
	}
	public String getQuesionTitle() {
		return quesionTitle;
	}
	public void setQuesionTitle(String quesionTitle) {
		this.quesionTitle = quesionTitle;
	}
	public int getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public double getQuestionMarks() {
		return questionMarks;
	}
	public void setQuestionMarks(double questionMarks) {
		this.questionMarks = questionMarks;
	}
	public int getChosenAnswer() {
		return chosenAnswer;
	}
	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}
	public double getMarksScored() {
		return MarksScored;
	}
	public void setMarksScored(double marksScored) {
		MarksScored = marksScored;
	}
	
	
}

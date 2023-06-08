package com.testapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
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
	private Long questionId;
	@Embedded
	private List<String> questionOptions=new ArrayList<>();
	private String quesionTitle;
	private int questionAnswer;
	private double questionMarks;
	private int chosenAnswer;
	private double marksScored;

	

	public Long getQuestionId() {
		return questionId;
	}



	public void setQuestionId(Long questionId) {
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
		return marksScored;
	}



	public void setMarksScored(double marksScored) {
		this.marksScored = marksScored;
	}

	public Question(Long questionId, List<String> questionOptions, String quesionTitle, int questionAnswer,
			double questionMarks, int chosenAnswer, double marksScored) {
		super();
		this.questionId = questionId;
		this.questionOptions = questionOptions;
		this.quesionTitle = quesionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
	}



	public Question() {
		super();
	}

}

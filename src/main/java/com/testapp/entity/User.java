package com.testapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long usedid;

	@NotBlank(message = "user name should not be blank or null ")
	private String userName;
	private boolean admin;
	//@NotBlank(message = "user password should not be blank or null ")
	private String userPassword;
	
	private String emailId;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "test_fk")
	private Test test;

	public User() {
		super();
	}

	public long getUsedid() {
		return usedid;
	}

	public void setUsedid(long usedid) {
		this.usedid = usedid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public User(long usedid, @NotBlank(message = "user name should not be blank or null ") String userName,
			boolean admin, @NotBlank(message = "user password should not be blank or null ") String userPassword,
			String emailId, Test test) {
		super();
		this.usedid = usedid;
		this.userName = userName;
		this.admin = admin;
		this.userPassword = userPassword;
		this.emailId = emailId;
		this.test = test;
	}
	
	

}

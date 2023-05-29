package com.testapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private boolean isAdmin;
	@NotBlank(message = "user password should not be blank or null ")
	private String userPassword;

	
	public User(long usedid, @NotBlank(message = "user name should not be blank or null ") String userName,
			boolean isAdmin, @NotBlank(message = "user password should not be blank or null ") String userPassword) {
		super();
		this.usedid = usedid;
		this.userName = userName;
		this.isAdmin = isAdmin;
		this.userPassword = userPassword;
	}

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
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [usedid=" + usedid + ", userName=" + userName + ", isAdmin=" + isAdmin + ", userPassword="
				+ userPassword + "]";
	}

}

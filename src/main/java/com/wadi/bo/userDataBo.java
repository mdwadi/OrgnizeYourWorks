package com.wadi.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "user")
public class userDataBo {

	private static final long serialVersionUID = -5019069986703932725L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false, length = 50)
	private String fname;

	@Column(nullable = false, length = 50)
	private String lname;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(nullable = false)
	private String encryptpassword;

	private String emailVerificationTokent;

	@Column(nullable = false)
	private Boolean emailVerificationStatus = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserid() {
		return userId;
	}

	public void setUserid(String userid) {
		this.userId = userid;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptpassword() {
		return encryptpassword;
	}

	public void setEncryptpassword(String encryptpassword) {
		this.encryptpassword = encryptpassword;
	}

	public String getEmailVerificationTokent() {
		return emailVerificationTokent;
	}

	public void setEmailVerificationTokent(String emailVerificationTokent) {
		this.emailVerificationTokent = emailVerificationTokent;
	}

	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}

}

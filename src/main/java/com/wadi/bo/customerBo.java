package com.wadi.bo;

import javax.persistence.Entity;

@Entity(name = "customerFile")
public class customerBo {

	private String sno;
	private String phoneNo;
	private String userName;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

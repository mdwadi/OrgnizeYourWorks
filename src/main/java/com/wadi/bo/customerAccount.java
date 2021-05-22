package com.wadi.bo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "customerAccount")
public class customerAccount {

	private String sno;
	private String from;
	private String add;
	private String withdraw;
	private String date;
	private String Descritpion;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "phoneNo")
	private Set<customerBo> customer;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescritpion() {
		return Descritpion;
	}

	public void setDescritpion(String descritpion) {
		Descritpion = descritpion;
	}

}

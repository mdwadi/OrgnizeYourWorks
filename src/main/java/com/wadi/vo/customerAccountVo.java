package com.wadi.vo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.wadi.bo.customerBo;

@Entity(name = "customerAccount")
public class customerAccountVo {

	private String sno;
	private String from;
	private String add;
	private String withdraw;
	private String date;
	private String Descritpion;
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

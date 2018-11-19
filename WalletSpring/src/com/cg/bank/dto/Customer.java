package com.cg.bank.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="customer1")
public class Customer {
	
	@Column(name="cust_name")
	private String name;
	
	@Id
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="age")
	private float age;
	
	@Column(name="ini_bal")
	private double initialBalance;
	
	@Transient
	private double amount;
	
	@Transient
	private String mobNo;
	
	public double getAmount() {
		return amount;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
	
	public double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	public Customer(String name, String mobileNo, float age, double initialBalance) {
		this.name = name;
		this.mobileNo = mobileNo;
		this.age = age;
		this.initialBalance = initialBalance;
	}
	public Customer() {
		super();
	}

}

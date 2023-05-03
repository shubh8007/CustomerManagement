package com.app.core;

import java.time.LocalDate;

public class Customer {
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private double regamount;
	private LocalDate dob;
	private Plan plan;
	private static int count;
	static {
		count=0;
	}
	public Customer(String fname, String lname, String email, String password, double regamount, LocalDate dob,
			Plan plan) {
		super();
		this.id = count++;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.regamount = regamount;
		this.dob = dob;
		this.plan = plan;
	}
	
	
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Customer(String email2) {
		this.email=email2;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", regamount=" + regamount + ", dob=" + dob + ", plan=" + plan + "]";
	}
	
	public boolean equals(Object o) {//argument is not type of p
		if(o instanceof Customer){  
			return  this.email.equals(((Customer)o).email);
			
		}
		return false;
		
	}





}

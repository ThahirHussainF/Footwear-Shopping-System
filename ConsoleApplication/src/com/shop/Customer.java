package com.shop;

import java.util.Date;
import java.util.Scanner;

public class Customer extends User {
	private static int id = 1;
	private String customerId;
	private String userName;
	private String password;

	public Customer() {
		//super();
		Date d = new Date();
		this.customerId = "BS" + (d.getYear() + 1900) + "C" + id++;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "\nCustomer Id: " + this.customerId +super.toString();
	}

}

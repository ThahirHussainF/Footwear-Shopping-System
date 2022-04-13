package com.shop;

import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class Customer extends User {
	private static int id = 1;
	private String customerId;
	private String userName;
	private String password;
    Scanner ob=new Scanner(System.in);

	public Customer() {
		//super();
		Date d = new Date();
		this.customerId = "BS" + (d.getYear() + 1900) + "C" + id++;
		Notification.customerNotifications.put(this.getCustomerId(),new Stack<String>());
	}
	public void menu(Notification notification) {
		boolean exit = true;
		System.out.println("***************Home*********************");
		do {
			System.out.println("");
			int choice = ob.nextInt();
			switch (choice) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				notification.notificationMenu("customer",this.getCustomerId());
				break;
			case 5:
				exit = false;
				break;
			}

		} while (exit);
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

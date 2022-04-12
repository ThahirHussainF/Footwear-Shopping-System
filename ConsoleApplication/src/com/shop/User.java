package com.shop;

import java.util.Scanner;

public class User {

	protected String firstName;
	protected String lastName;
	protected String emailId;
	protected String address = "";
	protected long phoneNumber;
	protected String country;
	protected int pincode;
	protected String state;
	protected String district;

	public User() {
//		System.out.println("\n******Registration******");
//		Scanner ob=new Scanner(System.in);
//		System.out.println("Enter the First name: ");
//		this.firstName=ob.next();
//		System.out.println("Enter the Last name: ");
//		this.lastName=ob.next();
//		System.out.println("Enter the Email ID: ");
//		this.emailId=ob.next();
//		System.out.println("Enter the Phone Number: ");
//		this.phoneNumber=ob.nextLong();
//		System.out.println("Enter the Address: ");
//		ob.nextLine();
//		this.address=ob.nextLine();
//		System.out.println("Enter the District: ");
//		this.district=ob.next();
//		ob.nextLine();
//		System.out.println("Enter the State: ");
//		this.state=ob.nextLine();
//		System.out.println("Enter the country: ");
//		this.country=ob.next();
//		System.out.println("Enter the pincode");
//		this.pincode=ob.nextInt();
	}

	@Override
	public String toString() {
		return "\nName: " + this.firstName + " " + this.lastName + "\nEmail Id: " + this.emailId + "\nPhone Number: "
				+ this.phoneNumber + "\nAddress: " + this.address + ", " + this.district + ", " + this.state + ", "
				+ this.country + " - " + this.pincode;
	}

}


package com.shop;

import java.util.Scanner;
//It is a blue print class which holds all common properties among all users(customer,seller and  admin)
public class User {

	protected String firstName;
	protected String lastName;
	protected String emailId;
	protected String address = "";
	protected String phoneNumber;
	protected String country;
	protected int pincode;
	protected String state;
	protected String district;
	public void userDetails() {
		System.out.println("\n******Registration******");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the First name: ");
		this.firstName=scanner.next();
		System.out.println("Enter the Last name: ");
		this.lastName=scanner.next();
		while(true) {
			System.out.println("Enter the Email ID: ");
			this.emailId=scanner.next();
			String regex = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}";
			if(Login.isValid(regex, this.emailId)) {
				break;
			} else {
				System.out.println("\nInvalid EmailId!Try again!.");
			}
		}
		while(true) {
			System.out.println("Enter the Phone Number: ");
			this.phoneNumber=scanner.next();
			String regex = "(0/91)?[7-9][0-9]{9}";
			if(Login.isValid(regex, this.phoneNumber)) {
				break;
			} else {
				System.out.println("\nInvalid phone number!Try again!.");
			}
		}
		System.out.println("Enter the Address: ");
		scanner.nextLine();
		this.address=scanner.nextLine();
		System.out.println("Enter the District: ");
		this.district=scanner.next();
		scanner.nextLine();
		System.out.println("Enter the State: ");
		this.state=scanner.nextLine();
		System.out.println("Enter the country: ");
		this.country=scanner.next();
		System.out.println("Enter the pincode");
		this.pincode=scanner.nextInt();
	}

	@Override
	public String toString() {
		return "\nName: " + this.firstName + " " + this.lastName + "\nEmail Id: " + this.emailId + "\nPhone Number: "
				+ this.phoneNumber + "\nAddress: " + this.address + ", " + this.district + ", " + this.state + ", "
				+ this.country + " - " + this.pincode;
	}

}

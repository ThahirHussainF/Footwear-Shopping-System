
package com.shop;

import java.util.InputMismatchException;
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
	protected byte accountStatus=1;//1-active,2-locked
	protected byte passwordLoginAttempts=3;//only 3 attempts


	public void userDetails() {
		String emailRegex = "[a-z.]+[0-9.]*@[a-z]+\\.[a-z]{2,3}";// for email validation
		String phoneNumberRegex = "(0/91)?[7-9][0-9]{9}";// for phone number validation
		String numberRegex = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$$";// for letter validation
		String letterRegex = "^[a-zA-Z\\s]*$";// for letter validation
		System.out.println("\n******Registration******");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the First name: ");
			this.firstName = scanner.next();
			if (Security.isValidRegex(letterRegex, firstName)) {
				break;
			}
			System.out.println("Please entered in letters!");
		}
		while (true) {
			System.out.println("Enter the Last name: ");
			this.lastName = scanner.next();
			if (Security.isValidRegex(letterRegex, lastName)) {
				break;
			}
			System.out.println("Please entered in letters!");
		}
		while (true) {
			System.out.println("Enter the Email ID: ");
			this.emailId = scanner.next();

			if (Security.isValidRegex(emailRegex, this.emailId)) {
				break;
			} else {
				System.out.println("\nInvalid EmailId!Try again!.");
			}
		}
		while (true) {
			System.out.println("Enter the Phone Number: ");
			this.phoneNumber = scanner.next();

			if (Security.isValidRegex(phoneNumberRegex, this.phoneNumber)) {
				break;
			} else {
				System.out.println("\nInvalid phone number!Try again!.");
			}
		}

		System.out.println("Enter the Address: ");
		scanner.nextLine();
		this.address = scanner.nextLine();
		while (true) {
			System.out.println("Enter the District: ");
			this.district = scanner.next();
			if (Security.isValidRegex(letterRegex, district)) {
				break;
			}
			System.out.println("Please entered in letters!");
		}
		scanner.nextLine();
		while (true) {
			System.out.println("Enter the State: ");
			this.state = scanner.nextLine();
			if (Security.isValidRegex(letterRegex, state)) {
				break;
			}
			System.out.println("Please entered in letters!");
		}
		while (true) {
			System.out.println("Enter the country: ");
			this.country = scanner.next();
			if (Security.isValidRegex(letterRegex, country)) {
				break;
			}
			System.out.println("Please entered in letters!");
		}
		do {
			System.out.println("Enter the pincode");
			try {
				this.pincode = scanner.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("Please enterd the numer!");
				scanner.nextLine();
			}
		}while(!Security.isValidRegex(numberRegex, String.valueOf(pincode)));
	

	}
   
	public byte getPasswordLoginAttempts() {
		return passwordLoginAttempts;
	}

	public void setPasswordLoginAttempts(byte passwordLoginAttempts) {
		this.passwordLoginAttempts = passwordLoginAttempts;
	}

	public byte getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(byte accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "\nName: " + this.firstName + " " + this.lastName + "\nEmail Id: " + this.emailId + "\nPhone Number: "
				+ this.phoneNumber + "\nAddress: " + this.address + ", " + this.district + ", " + this.state + ", "
				+ this.country + " - " + this.pincode;
	}

}

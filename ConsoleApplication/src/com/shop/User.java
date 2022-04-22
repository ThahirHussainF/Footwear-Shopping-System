
package com.footwearShop;

import java.util.InputMismatchException;
import java.util.Scanner;

//It is a blue print user class which holds all common properties among all users(customer,seller and  admin)
public class User {

	protected String firstName;// It stores first name.
	protected String lastName;// It stores last name.
	protected String emailId;// It stores email Id.
	protected String address;// It stores address.
	protected String phoneNumber;// It stores phone number.
	protected String country;// It stores country name
	protected int pincode;// It stores pincode.
	protected String state;// It stores state name
	protected String district;// It stores district name.
	protected byte accountStatus = 1;// 1-active,2-locked
	protected byte passwordLoginAttempts = 3;// only 3 attempts
	Scanner scanner = new Scanner(System.in);
	// It is used get the user details.
	public void getUserDetails() {
		String emailRegex = "[a-z.]+[0-9.]*@[a-z]+\\.[a-z]{2,3}";// for email validation
		String phoneNumberRegex = "(0/91)?[7-9][0-9]{9}";// for phone number validation
		String numberRegex = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$$";// for letter validation
		String letterRegex = "^[a-zA-Z\\s]*$";// for letter validation
		System.out.println("\n******Registration******");
		// Get the first name.
		while (true) {
			System.out.println("Enter the First name: ");
			this.firstName = scanner.next();
			if (Security.isValidPattern(letterRegex, firstName)) {
				break;
			}
			System.out.println("Please entered in letters!");
		}
		// Get the last name.
		scanner.nextLine();
		while (true) {
			System.out.println("Enter the Last name: ");
			this.lastName = scanner.nextLine();
			if (Security.isValidPattern(letterRegex, lastName)) {
				break;
			}
			System.out.println("Please entered in letters!");
		}
		// Get the email Id.
		while (true) {
			System.out.println("Enter the Email ID: ");
			this.emailId = scanner.next();

			if (Security.isValidPattern(emailRegex, this.emailId)) {
				break;
			} else {
				System.out.println("\nInvalid EmailId!Try again!.");
			}
		}
		// Get the phone number.
		while (true) {
			System.out.println("Enter the Phone Number: ");
			this.phoneNumber = scanner.next();

			if (Security.isValidPattern(phoneNumberRegex, this.phoneNumber)) {
				break;
			} else {
				System.out.println("\nInvalid phone number!Try again!.");
			}
		}
		// Get the address.
		System.out.println("Enter the Address: ");
		scanner.nextLine();
		this.address = scanner.nextLine();
		while (true) {
			System.out.println("Enter the District: ");
			this.district = scanner.next();
			if (Security.isValidPattern(letterRegex, district)) {
				break;
			}
			System.out.println("Please entered in letters!");
		}
		scanner.nextLine();
		// Get the state name.
		while (true) {
			System.out.println("Enter the State: ");
			this.state = scanner.nextLine();
			if (Security.isValidPattern(letterRegex, state)) {
				break;
			}
			System.out.println("Please entered in letters!");
		}
		// Get the country name.
		while (true) {
			System.out.println("Enter the country: ");
			this.country = scanner.next();
			if (Security.isValidPattern(letterRegex, country)) {
				break;
			}
			System.out.println("Please entered in letters!");
		}
		// Get the pincode.
		do {
			System.out.println("Enter the pincode");
			try {
				this.pincode = scanner.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("Please enterd the numer!");
				scanner.nextLine();
			}
		} while (!Security.isValidPattern(numberRegex, String.valueOf(pincode)));

	}

	// It is used to get the password login attempts.
	public byte getPasswordLoginAttempts() {
		return passwordLoginAttempts;
	}

	// It is used to set the password login attempts.
	public void setPasswordLoginAttempts(byte passwordLoginAttempts) {
		this.passwordLoginAttempts = passwordLoginAttempts;
	}

	// It is used to get account status.
	public byte getAccountStatus() {
		return accountStatus;
	}

	// It is used to set account status.
	public void setAccountStatus(byte accountStatus) {
		this.accountStatus = accountStatus;
	}
	// It is used to print user details whenever we print user object.
	@Override
	public String toString() {
		return "\nName: " + this.firstName + " " + this.lastName + "\nEmail Id: " + this.emailId + "\nPhone Number: "
				+ this.phoneNumber + "\nAddress: " + this.address + ", " + this.district + ", " + this.state + ", "
				+ this.country + " - " + this.pincode;
	}

}

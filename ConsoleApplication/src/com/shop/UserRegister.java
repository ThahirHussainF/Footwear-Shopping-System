package com.footwearShop;

import java.util.Scanner;

public class UserRegister {
	private String userName = "";// which is used to store user name
	private String password = "";// which is used to store password
	static Scanner scanner = new Scanner(System.in);

	// It is used to perform registration operation.
	public void doRegister(String user) {// user means "CUSTOMER","SELLER","ADMIN"
		System.out.println(
				"Rules for Valid User name\n1.It contains at least 5 characters and at most 8 characters.\n2.It contains at least one digit,one lowercase alphabet,one upper case alphabet.");

		System.out.println("Enter the userName: ");
		userName=scanner.next();
		this.userName = validateUserName(user, userName);
		System.out.println(
				"Rules for Valid Password\n1.It contains at least 8 characters and at most 20 characters.\n2.It contains at least one digit,one lowercase alphabet,one upper case alphabet and one special character.\n3.It does not contain whitespace.");
		System.out.println("\nEnter the password: ");
		password=scanner.next();
		this.password = validatePasword(user, password);
		Storage.addUser(user, userName, password);
	}

	// It is used to check if user Name was valid format or not
	public static String validateUserName(String user, String userName) {
		while (true) {
			String regex = "^(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z]).{5,8}$";
			if (Security.isValidPattern(regex, userName)) {
				if (Security.isNewOrExistingUser(user, userName)) {
					System.out.println("Already exists!");
					continue;
				} else {
					return userName;
				}
			} else {
				System.out.println("Invalid userName format!\nEnter the User name again: ");
				userName = scanner.next();
			}

		}

	}
	// It is used to check if password was valid format or not
	public static String validatePasword(String user, String password) {
		while (true) {
			String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
			if (!Security.isValidPattern(regex, password)) {
				System.out.println("Invalid Password format!\nEnter the password again: ");
				password = scanner.next();
				continue;
			}
			return password;
		}
	}
}

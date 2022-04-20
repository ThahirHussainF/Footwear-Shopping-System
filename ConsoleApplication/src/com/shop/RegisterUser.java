package com.shop;

import java.util.Scanner;

public class RegisterUser {
	private String username = "";
	private String password = "";
	private String user;//which type of user whether 'customer' , 'seller' and 'admin'
	Storage storage;//It is used to create storage object for managing all accounts.
	Scanner scanner = new Scanner(System.in);
	public  void registerNewUser(String user) {
    	
		while (true) {
			System.out.println("Enter the username: ");
			username = scanner.next();
			String regex = "^(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z]).{5,8}$";
			if (Security.isValidRegex(regex, username)) {
				if (Security.checknewOrAlreadyExistingUser(user, username)) {
					System.out.println("Already exists!");
					continue;
				} else {
					break;
				}
			} else {
				System.out.println("Invalid username format!.Try Again");
			}

		}
		while (true) {
			System.out.println(
					"Rules for Valid Password\n1.It contains at least 8 characters and at most 20 characters.\n2.It contains at least one digit,one lowercase alphabet,one upper case alphabet and one special character.\n3.It does not contain whitespace.");
			System.out.println("\nEnter the password: ");
			password = scanner.next();
			String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
			if (!Security.isValidRegex(regex, password)) {
				System.out.println("Invalid Password format!.Try Again");
				continue;
			}
			break;
		}
		Storage.addToSystem(user, username, password);
 }
}

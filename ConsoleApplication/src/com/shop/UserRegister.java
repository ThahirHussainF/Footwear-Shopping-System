package com.shop;

import java.util.Scanner;

public class UserRegister {
	private String userName = "";//which is used to store user name
	private String password = "";//which is used to store password
	Scanner scanner = new Scanner(System.in);
	//It is used to perform registration operation.
	public  void doRegister(String user) {//user means "CUSTOMER","SELLER","ADMIN"
		while (true) {
			System.out.println("Enter the userName: ");
			userName = scanner.next();
			String regex = "^(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z]).{5,8}$";
			if (Security.isValidPattern(regex, userName)) {
				if (Security.isNewOrExistingUser(user, userName)) {
					System.out.println("Already exists!");
					continue;
				} else {
					break;
				}
			} else {
				System.out.println("Invalid userName format!.Try Again");
			}

		}
		while (true) {
			System.out.println(
					"Rules for Valid Password\n1.It contains at least 8 characters and at most 20 characters.\n2.It contains at least one digit,one lowercase alphabet,one upper case alphabet and one special character.\n3.It does not contain whitespace.");
			System.out.println("\nEnter the password: ");
			password = scanner.next();
			String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
			if (!Security.isValidPattern(regex, password)) {
				System.out.println("Invalid Password format!.Try Again");
				continue;
			}
			break;
		}
		Storage.addUser(user, userName, password);
 }
}

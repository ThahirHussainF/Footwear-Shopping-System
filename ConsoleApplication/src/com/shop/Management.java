
package com.shop;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

//It is used to manage the login accounts for all users(customer, seller, admin)
public class Management {

	// This constructor is invoked to categorize the users(customer, seller and
	// admin)
	public Management(Storage account) {
		boolean exit = true;
		do {
			int choice;
			System.out.println("****************************************************");
			System.out.println("\n--LOGIN--\n");
			System.out.println("1.Customer\n2.Seller\n3.Admin\n4.Go to Welcome Page\n5.Leave Shop");
			System.out.println("****************************************************");
			choice = checkValidityOfChoice();
			switch (choice) {
			case 1:
				new Login("customer", account);
				break;
			case 2:
				new Login("seller", account);
				break;
			case 3:
				new Login("admin", account);
				break;
			case 4:
				new WelcomePage(account);
				break;
			case 5:
				System.out.println("Thank you for visiting our store!!");
				exit = false;
				break;
			default:
				System.out.print("Please enter the valid choice!");
				break;
			}
		} while (exit);
	}

	public static int checkValidityOfChoice() {
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your choice:");
		do {
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException exception) {
				scanner.nextLine();
				System.out.print("Please enter the valid choice!");
			}
		} while (!Pattern.matches("^[1-9]*$", String.valueOf(choice)));
		return choice;
	}

}

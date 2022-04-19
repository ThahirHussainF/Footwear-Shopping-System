
package com.shop;

import java.util.Scanner;
//It is used to manage the login accounts for all users(customer, seller, admin)
public class Management {
	//This constructor is invoked to categorize the users(customer, seller and admin) 
	public Management(Accounts account) {
		boolean exit = true;
		do {
			int choice;
			Scanner scanner = new Scanner(System.in);
			System.out.println("****************************************************");
			System.out.println("\nLOGIN\n");
			System.out.println("1.Customer\n2.Seller\n3.Admin\n4.Exit\nEnter your choice:");
			System.out.println("****************************************************");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				new Login("customer",account);
				break;
			case 2:
				new Login("seller",account);
				break;
			case 3:
				new Login("admin",account);
				break;
			case 4:
				new WelcomePage();
				System.out.println("Thank you for visiting our store!!");
				exit=false;
				break;

			}
		} while (exit);
	}

}

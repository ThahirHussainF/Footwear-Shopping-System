package com.shop;

import java.util.Scanner;

public class Management {
	public Management() {
		
		
		boolean exit = true;
		do {
			int choice;
			Scanner ob = new Scanner(System.in);
			System.out.println("****************************************************");
			System.out.println("\nWelcome to Bismi Footwear Mart\n");
			System.out.println("1.Customer\n2.Seller\n3.Admin\n4.Exit");
			System.out.println("****************************************************");
			choice = ob.nextInt();
			switch (choice) {
			case 1:
				new Login("customer");
				break;
			case 2:
				new Login("seller");
				break;
			case 3:
				new Login("admin");
				break;
			case 4:
				System.out.println("Thank you for visiting our store!!");
				exit=false;
				break;

			}
		} while (exit);
	}

}


package com.shop;

import java.util.Scanner;
//It is used to do all notification related operations.
public class Notification {
	Scanner scanner = new Scanner(System.in);
    //It is used to show notification menu for Customer.
	public void showNotificationMenuForCustomer(String userId) {
		boolean exit = true;
		System.out.println("\n**************Notification Bar***************\n");
			do {
				System.out.println("\n1.Show notifications\n2.send notification to seller\n"
						+ "3.send notification to admin\n4.delete notifications\n5.close\nEnter the choice: ");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					showNotifications("customer",userId);
					break;
				case 2:
					sendNotifications("seller");
					break;
				case 3:
					sendNotifications("admin");
					break;
				case 4:
					deleteNotifications("customer",userId);
					break;
				case 5:
					exit = false;
					break;
				}
			} while (exit);
		}
	//It is used to show notification menu for Seller.
	public void showNotificationMenuForSeller(String userId) {
		boolean exit = true;
		System.out.println("\n**************Notification Bar***************\n");
		do {
			System.out.println("\n1.Show notifications\n2.send notification to customer\n"
					+ "3.send notification to admin\n4.delete notifications\n5.close\nEnter the choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				showNotifications("seller",userId);
				break;
			case 2:
				sendNotifications("customer");
				break;
			case 3:
				sendNotifications("admin");
				break;
			case 4:
				deleteNotifications("seller",userId);
				break;
			case 5:
				exit = false;
				break;
			}
		} while (exit);
		} 
	//It is used to show notification menu for Admin.
	public void showNotificationMenuForAdmin(String userId) {
		boolean exit = true;
		System.out.println("\n**************Notification Bar***************\n");
		do {

			System.out.println("\n1.Show notifications\n2.send notification to customer\n"
					+ "3.send notification to seller\n4.delete notifications\n5.close\nEnter the choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				showNotifications("admin",userId);
				break;
			case 2:
				sendNotifications("customer");
				break;
			case 3:
				sendNotifications("seller");
				break;
			case 4:
				deleteNotifications("admin",userId);
				break;
			case 5:
				exit = false;
				break;
			}
		} while (exit);
	}
	//It is used to send the notification
	public void sendNotifications(String user) {
		System.out.println("Enter the " + user + " Id: ");
		String userId = scanner.next();
		scanner.nextLine();
		System.out.println("Enter the query to" + userId + ":");
		String query = scanner.nextLine();
		if (user.equals("customer")) {
			Storage.customerNotifications.get(userId).add(query);
		} else if (user.equals("seller")) {
			Storage.sellerNotifications.get(userId).add(query);
		} else if (user.equals("admin")) {
			Storage.adminNotifications.get(userId).add(query);
		}
		System.out.println("Notification was sent sucessfully!");
	}
	//It is used to show the notification
	public void showNotifications(String user,String userId) {
		
		boolean customer = user.equals("customer") && Storage.customerNotifications.get(userId).isEmpty();
		boolean seller = user.equals("seller") && Storage.sellerNotifications.get(userId).isEmpty();
		boolean admin = user.equals("admin") && Storage.adminNotifications.get(userId).isEmpty();
		if (customer || seller || admin) {
			System.out.println("Notification bar was empty!");
		}
		if (user.equals("customer")) {

			for (String query : Storage.customerNotifications.get(userId)) {
				System.out.println(query);
			}

		} else if (user.equals("seller")) {

			for (String query : Storage.sellerNotifications.get(userId)) {
				System.out.println(query);
			}
		} else if (user.equals("admin")) {

			for (String query : Storage.adminNotifications.get(userId)) {
				System.out.println(query);
			}
		}
	}
	//It is used to delete the notification
	public void deleteNotifications(String user,String userId) {
		if (user.equals("customer")) {
			Storage.customerNotifications.get(userId).pop();
		} else if (user.equals("seller")) {
			Storage.sellerNotifications.get(userId).pop();
		} else if (user.equals("admin")) {
			Storage.adminNotifications.get(userId).pop();
		}
		System.out.println("Notification was deleted!");
	}

}

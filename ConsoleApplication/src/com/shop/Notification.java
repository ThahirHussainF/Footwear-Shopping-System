package com.shop;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

import java.util.Stack;

public class Notification {

	static Map<String, Stack<String>> customerNotifications = new HashMap<>();
	static Map<String, Stack<String>> sellerNotifications = new HashMap<>();
	static Map<String, Stack<String>> adminNotifications = new HashMap<>();
	Scanner ob = new Scanner(System.in);

	public void notificationMenu(String user,String userId) {
		boolean exit = true;
		System.out.println("\n**************Notification Bar***************\n");
		if (user.equals("customer")) {
			do {
				System.out.println("\n1.Show notifications\n2.send notification to seller\n"
						+ "3.send notification to admin\n4.delete notifications\n5.close\nEnter the choice: ");
				int choice = ob.nextInt();
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
		} else if (user.equals("seller")) {
			do {
				System.out.println("\n1.Show notifications\n2.send notification to customer\n"
						+ "3.send notification to admin\n4.delete notifications\n5.close\nEnter the choice: ");
				int choice = ob.nextInt();
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
		} else if (user.equals("admin")) {
			do {

				System.out.println("\n1.Show notifications\n2.send notification to customer\n"
						+ "3.send notification to seller\n4.delete notifications\n5.close\nEnter the choice: ");
				int choice = ob.nextInt();
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

	}

	public void sendNotifications(String user) {
		System.out.println("Enter the " + user + " Id: ");
		String userId = ob.next();
		ob.nextLine();
		System.out.println("Enter the query to" + userId + ":");
		String query = ob.nextLine();
		if (user.equals("customer")) {
			customerNotifications.get(userId).add(query);
		} else if (user.equals("seller")) {
			sellerNotifications.get(userId).add(query);
		} else if (user.equals("admin")) {
			adminNotifications.get(userId).add(query);
		}
		System.out.println("Notification was sent sucessfully!");
	}

	public void showNotifications(String user,String userId) {
		
		boolean customer = user.equals("customer") && customerNotifications.get(userId).isEmpty();
		boolean seller = user.equals("seller") && sellerNotifications.get(userId).isEmpty();
		boolean admin = user.equals("admin") && adminNotifications.get(userId).isEmpty();
		if (customer || seller || admin) {
			System.out.println("Notification bar was empty!");
		}
		if (user.equals("customer")) {

			for (String query : customerNotifications.get(userId)) {
				System.out.println(query);
			}

		} else if (user.equals("seller")) {

			for (String query : sellerNotifications.get(userId)) {
				System.out.println(query);
			}
		} else if (user.equals("admin")) {

			for (String query : adminNotifications.get(userId)) {
				System.out.println(query);
			}
		}
	}

	public void deleteNotifications(String user,String userId) {
		if (user.equals("customer")) {
			customerNotifications.get(userId).pop();
		} else if (user.equals("seller")) {
			sellerNotifications.get(userId).pop();
		} else if (user.equals("admin")) {
			adminNotifications.get(userId).pop();
		}
		System.out.println("Notification was deleted!");
	}

}

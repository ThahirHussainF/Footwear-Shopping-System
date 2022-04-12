package com.shop;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Admin extends User {
	private String username;
	private String password;
	private static int id = 1;
	private String adminId;
	static Map<String, Shop> shops = new HashMap<>();
	static Queue<Shop> approvalQueueforCreatingShop = new LinkedList<>();
	static Queue<String> approvalQueueforDeletingShop = new LinkedList<>();
	Scanner ob = new Scanner(System.in);

	public Admin() {
		Date date = new Date();
		this.adminId = "BS" + (date.getYear() + 1900) + "A" + id++;
	}

	public void menu() {
		boolean exit = true;
		System.out.println("***************Home*********************");
		do {
			System.out.println(
					"\n1.Approval for creating shop\n2.Approval for deleting shop\n3.Logout\nEnter your choice: ");
			int choice = ob.nextInt();
			switch (choice) {
			case 1:
				this.approvalAndRejectionOperartionPerformedForCreatingShop();
				break;
			case 2:
				this.approvalAndRejectionOperartionPerformedForDeletingShop();
				break;
			case 3:
				exit = false;
				break;
			}

		} while (exit);
	}

	public static void approvalOrRejectionOfShops(String sellerId, Shop shop) {
		approvalQueueforCreatingShop.add(shop);
		shops.put(sellerId, shop);
	}

	public void approvalAndRejectionOperartionPerformedForCreatingShop() {
		System.out.println("Shops waiting for Creation:");
		for (Shop shop : this.approvalQueueforCreatingShop) {
			System.out.println(shop.toString());
			System.out.println("\n1.Approval\n2.Denial\nEnter your status: ");
			int status = ob.nextInt();
			shop.setShopStatus(status);
			System.out.println("Shop was created successfully!");
			this.approvalQueueforCreatingShop.remove();
		}
	}

	public void approvalAndRejectionOperartionPerformedForDeletingShop() {
		System.out.println("Shops waiting for Deletion:");
		for (String shopId : this.approvalQueueforDeletingShop) {
			//on progress
			System.out.println("\n1.Approval\n2.Denial\nEnter your status: ");
			int status = ob.nextInt();
			if (status == 1) {
				
				System.out.println("Shop was deleted successfully!");
			}
			this.approvalQueueforDeletingShop.remove();
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

}

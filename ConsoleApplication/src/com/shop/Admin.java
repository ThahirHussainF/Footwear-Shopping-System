package com.shop;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

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
		Notification.adminNotifications.put(this.getAdminId(),new Stack<String>());
	}
	public void menu(Notification notification) {
		boolean exit = true;
		System.out.println("***************Home*********************");
		do {
			System.out.println(
					"\n1.Approval for creating shop\n2.Approval for deleting shop\n3.Notifications\n4.Logout\nEnter your choice: ");
			int choice = ob.nextInt();
			switch (choice) {
			case 1:
				this.approvalAndRejectionOperartionPerformedForCreatingShop();
				break;
			case 2:
				this.approvalAndRejectionOperartionPerformedForDeletingShop();
				break;
			case 3:
				notification.notificationMenu("admin",this.getAdminId());
				break;
			case 4:
				exit = false;
				break;
			}

		} while (exit);
	}

	public static void approvalOrRejectionOfShops(Shop shop) {
		approvalQueueforCreatingShop.add(shop);
		
	}

	public void approvalAndRejectionOperartionPerformedForCreatingShop() {
		if(this.approvalQueueforCreatingShop.isEmpty()) {
			System.out.println("No shops were waiting for Creation!");
			return;
		}
		System.out.println("Shops waiting for Creation:");
		for (Shop shop : this.approvalQueueforCreatingShop) {
			System.out.println(shop.toString());
			System.out.println("\n1.Approval\n2.Denial\nEnter your status: ");
			int status = ob.nextInt();
			shop.setShopStatus(status);
			if(status==1) {
				Notification.sellerNotifications.get(shop.getSeller().getSellerID()).add("Your shop was created sucessfully!");
				System.out.println("Request was accepted!");
			}
			else
			{
				Notification.sellerNotifications.get(shop.getSeller().getSellerID()).add("Your shop creation request was denied!");
				System.out.println("Request was denied!");
			}
	
			this.approvalQueueforCreatingShop.remove();
		}
	}

	public void approvalAndRejectionOperartionPerformedForDeletingShop() {
		if(this.approvalQueueforDeletingShop.isEmpty()) {
			System.out.println("No shops were waiting for Deletion!");
			return;
		}
		System.out.println("Shops waiting for Deletion:");
		for (String shopId : this.approvalQueueforDeletingShop) {
              for(Map.Entry<String, Shop> sellerWithShop:shops.entrySet()) {
            	Shop shop=sellerWithShop.getValue();
            	System.out.println(shop);
            	System.out.println("\n1.Approval\n2.Denial\nEnter your status: ");
      			int status = ob.nextInt();
      			if(status==1) {
      				shops.remove(sellerWithShop.getKey());
    				Notification.sellerNotifications.get(shop.getSeller().getSellerID()).add("Your shop was deleted sucessfully!");
    				System.out.println("Request was accepted!");
    			}
    			else
    			{
    				Notification.sellerNotifications.get(shop.getSeller().getSellerID()).add("Your shop deletion request was denied!");
    				System.out.println("Request was denied!");
    			}
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

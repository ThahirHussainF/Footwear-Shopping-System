
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
	private static byte id = 1;
	private String adminId;
	static Queue<Shop> approvalQueueforCreatingShop = new LinkedList<>();//which is used to store all shop object for creating shop to get approval from admin(First in First out).
	static Queue<String> approvalQueueforDeletingShop = new LinkedList<>();//which is used to store all shop object for deleting shop to get approval from admin(First in First out).
	Scanner scanner = new Scanner(System.in);
	public Admin() {
		//this.userDetails();
		Date date = new Date();
		this.adminId = "BS" + (date.getYear() + 1900) + "A" + id++;
		Notification.adminNotifications.put(this.getAdminId(),new Stack<String>());
	}
	//It is used to show the menu for all operations related to Admin.
	public void menu(Notification notification) {
		boolean exit = true;
		System.out.println("***************Home*********************");
		do {
			System.out.println(
					"\n1.Approval for creating shop\n2.Approval for deleting shop\n3.Notifications\n4.Logout");
			int choice = Management.checkValidityOfChoice();
			switch (choice) {
			case 1:
				this.approvalAndRejectionOperartionPerformedForCreatingShop();
				break;
			case 2:
				this.approvalAndRejectionOperartionPerformedForDeletingShop();
				break;
			case 3:
				notification.notificationMenuForAdmin(this.getAdminId());
				break;
			case 4:
				exit = false;
				break;
			default:
				System.out.print("Please enter the valid choice!");
				break;	
			}

		} while (exit);
	}
    //It is used to store all shops objects in queue for creating shop.
	public static void approvalOrRejectionOfShops(Shop shop) {
		approvalQueueforCreatingShop.add(shop);
		
	}
	//It is used to give approval/denial to seller for creating shop through admin.
	public void approvalAndRejectionOperartionPerformedForCreatingShop() {
		if(this.approvalQueueforCreatingShop.isEmpty()) {
			System.out.println("No shops were waiting for Creation!");
			return;
		}
		System.out.println("Shops waiting for Creation:");
		for (Shop shop : this.approvalQueueforCreatingShop) {
			System.out.println(shop.toString());
			System.out.println("\n1.Approval\n2.Denial\nEnter your status: ");
			int status = scanner.nextInt();
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
	//It is used to give approval/denial to seller for deleting shop through admin.
	public void approvalAndRejectionOperartionPerformedForDeletingShop() {
		if(this.approvalQueueforDeletingShop.isEmpty()) {
			System.out.println("No shops were waiting for Deletion!");
			return;
		}
		System.out.println("Shops waiting for Deletion:");
		for (String shopId : this.approvalQueueforDeletingShop) {
              for(Map.Entry<String, Shop> sellerWithShop:Storage.shops.entrySet()) {
            	Shop shop=sellerWithShop.getValue();
            	System.out.println(shop);
            	System.out.println("\n1.Approval\n2.Denial\nEnter your status: ");
      			int status = scanner.nextInt();
      			if(status==1) {
      				Storage.shops.remove(sellerWithShop.getKey());
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
    //It is used to get the user name from admin object.
	public String getUsername() {
		return username;
	}
	//It is used to set the user name to admin object.
	public void setUsername(String username) {
		this.username = username;
	}
	//It is used to get the password from admin object.
	public String getPassword() {
		return password;
	}
	//It is used to set the password to admin object.
	public void setPassword(String password) {
		this.password = password;
	}
	//It is used to get the admin Id from admin object.
	public String getAdminId() {
		return adminId;
	}
	//It is used to set the admin Id to admin object.
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

}

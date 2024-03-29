
package com.footwearShop;

import java.util.Calendar;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
////It is used to perform all operations related to Admin.
public class Admin extends User {
	private String username;// It stores user name.
	private String password;// It stores password
	private static byte id = 1;
	private String adminId;// It stores admin ID.
	static Queue<Shop> approvalQueueforCreatingShop = new LinkedList<>();// which is used to store all shop object for
																			// creating shop to get approval from
																			// admin(First in First out).
	static Queue<String> approvalQueueforDeletingShop = new LinkedList<>();// which is used to store all shop object for
																			// deleting shop to get approval from
																			// admin(First in First out).
	Scanner scanner = new Scanner(System.in);

	// It is invoked whenever new admin was registered.
	public Admin() {
		this.getUserDetails();
		this.adminId = "BS" + Calendar.getInstance().get(Calendar.YEAR) + "A" + id++;
		Storage.adminNotifications.put(this.getAdminId(), new Stack<String>());
	}

	// It is used to show the menu for all operations related to Admin.
	public void showAdminMenu(Notification notification) {
		boolean exit = true;
		System.out.println("***************Home*********************");
		do {
			System.out
					.println("\n1.Approval for creating shop\n2.Approval for deleting shop\n3.Notifications\n4.Logout");
			int choice = Security.validateChoice();
			switch (choice) {
			case 1:
				this.isCreateShop();
				break;
			case 2:
				this.isDeleteShop();
				break;
			case 3:
				notification.showNotificationMenuForAdmin(this.getAdminId());
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

	// It is used to give approval/denial to seller for creating shop through admin.
	public void isCreateShop() {
		if (Admin.approvalQueueforCreatingShop.isEmpty()) {
			System.out.println("No shops were waiting for Creation!");
			return;
		}
		System.out.println("Shops waiting for Creation:");
		for (Shop shop : Admin.approvalQueueforCreatingShop) {
			System.out.println(shop.toString());
			System.out.println("\n1.Approval\n2.Denial\nEnter your status: ");
			int status = scanner.nextInt();
			shop.setShopStatus(status);
			if (status == 1) {
				Storage.sellerNotifications.get(shop.getSeller().getSellerID())
						.add("Your shop was created sucessfully!");
				System.out.println("Request was accepted!");
			} else {
				Storage.sellerNotifications.get(shop.getSeller().getSellerID())
						.add("Your shop creation request was denied!");
				System.out.println("Request was denied!");
			}

			Admin.approvalQueueforCreatingShop.remove();
		}
	}

	// It is used to give approval/denial to seller for deleting shop through admin.
	public void isDeleteShop() {
		if (approvalQueueforDeletingShop.isEmpty()) {
			System.out.println("No shops were waiting for Deletion!");
			return;
		}
		System.out.println("Shops waiting for Deletion:");
		for (String shopId : approvalQueueforDeletingShop) {
			for (Map.Entry<String, Shop> sellerWithShop : Storage.shopsMap.entrySet()) {
				Shop shop = sellerWithShop.getValue();
				if (shop.getShopId().equals(shopId)) {
					System.out.println(shop);
					System.out.println("\n1.Approval\n2.Denial\nEnter your status: ");
					int status = scanner.nextInt();
					if (status == 1) {
						Storage.shopsMap.remove(sellerWithShop.getKey());
						Storage.sellerNotifications.get(shop.getSeller().getSellerID())
								.add("Your shop was deleted sucessfully!");
						System.out.println("Request was accepted!");
					} else {
						Storage.sellerNotifications.get(shop.getSeller().getSellerID())
								.add("Your shop deletion request was denied!");
						System.out.println("Request was denied!");
					}
				}

				Admin.approvalQueueforDeletingShop.remove();
			}
		}
	}

	// It is used to get the user name from admin object.
	public String getUsername() {
		return username;
	}

	// It is used to set the user name to admin object.
	public void setUsername(String username) {
		this.username = username;
	}

	// It is used to get the password from admin object.
	public String getPassword() {
		return password;
	}

	// It is used to set the password to admin object.
	public void setPassword(String password) {
		this.password = password;
	}

	// It is used to get the admin Id from admin object.
	public String getAdminId() {
		return adminId;
	}

	// It is used to set the admin Id to admin object.
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

}

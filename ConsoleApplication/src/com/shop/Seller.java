package com.shop;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Seller extends User {
	static int id = 1;
	private String sellerID;
	private String shopName;
	private String shopAddress;
	private String password;
	private String userName;
	private Shop myShop;
	Scanner ob = new Scanner(System.in);
	public Seller() {
		System.out.println("Enter the shop name: ");
		this.shopName = ob.nextLine();
		System.out.println("Enter the shop address: ");
		this.shopAddress = ob.nextLine();
		Date d = new Date();
		this.sellerID = "BS" + (d.getYear() + 1900) + "S" + id++;
		Notification.sellerNotifications.put(this.getSellerID(), new Stack<String>());
	}

	public void menu(Notification notification) {
		boolean exit = true;
		System.out.println("***************Home*********************");
		do {
			System.out.println(
					"\n1.Creating my new Shop\n2.Check the status of my shop\n3.Deleting my Shop\n4.Notifications\n5.Logout\nEnter your choice: ");
			int choice = ob.nextInt();
			switch (choice) {
			case 1:
				this.createShop();
				break;
			case 2:
				this.checkStatusOfTheShop();
				break;
			case 3:
				this.deleteShop();
				break;
			case 4:
				notification.notificationMenu("seller",this.getSellerID());
				break;
			case 5:
				exit = false;
				break;
			}

		} while (exit);
	}

	
	public void createShop() {
		Shop shop = new Shop();
		shop.setOwnerName(this.firstName + " " + this.lastName);
		shop.setSeller(this);
		shop.setShopName(shopName);
		this.setMyShop(shop);
		Admin.shops.put(this.getSellerID(), shop);
		Admin.approvalOrRejectionOfShops(shop);
		System.out.println(this.myShop.toString());
		System.out.println("please waiting for approval from admin...........");
		
	}

	public void checkStatusOfTheShop() {
		if (this.myShop == null) {
			System.out.println("There is no shop linked with this account!");
			return;
		}
		if (Admin.shops.containsKey(this.getSellerID())) {
			Shop shop = Admin.shops.get(this.sellerID);
			int status = shop.getShopStatus();
			if (status == 0) {
				System.out.println("Your shop was not yet approved!");
			} else if (status == 1) {
				System.out.println("Your account was currently active");
			} else if (status == 2) {
				System.out.println("Your account was currently inactive");
			}
		} else {
			System.out.println("Your shop was not found!");
		}
	}

	public void deleteShop() {
		System.out.println("Enter the shopId to delete");
		String shopId = ob.next();
		if (Admin.shops.containsKey(this.getSellerID())) {
			if(Admin.shops.get(this.getSellerID()).getShopStatus()==0) {
				System.out.println("Your shop was not yet approved.You can't delete the shop.");
				return;
			}
			Admin.approvalQueueforDeletingShop.add(shopId);
			System.out.println("let us contact you as soon as possible......");
		} else {
			System.out.println("There is no shop present for this account!");
		}

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Seller.id = id;
	}

	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public Shop getMyShop() {
		return myShop;
	}

	public Shop getMyShop(String sellerId) {
		return myShop;
	}

	public void setMyShop(Shop myShop) {
		this.myShop = myShop;
	}

	public String toString() {
		return "\nSeller Id: " + this.sellerID + "\nShop Name: " + this.shopName + "\nShop address: " + this.shopAddress
				+ super.toString();
	}
}

package com.shop;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

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
	}

	public void menu() {
		boolean exit = true;
		System.out.println("***************Home*********************");
		do {
			System.out.println(
					"\n1.Creating my new Shop\n2.Check the status of my shop\n3.Deleting my Shop\n4.Logout\nEnter your choice: ");
			int choice = ob.nextInt();
			switch (choice) {
			case 1:
				this.createShop();
				break;
			case 2:
				this.checkStatusOfTheShop(this.myShop.getShopId());
				break;
			case 3:
				System.out.println("Enter the shopId to delete");
				String shopId=ob.next();
				this.deleteShop(shopId);
				break;
			case 4:
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
		Admin.approvalOrRejectionOfShops(this.getSellerID(), shop);
		System.out.println("please waiting for approval from admin...........");
		this.myShop = shop;
	}

	public void checkStatusOfTheShop(String shopId) {

		if (Admin.shops.containsKey(shopId)) {
			for (Shop shop : Admin.shops.values()) {
				if (shop.getShopId() == shopId) {
					int status = shop.getShopStatus();
					if (status == 0) {
						System.out.println("Your shop not yet approved.please waiting some time!");
						return;
					} else if (status == 1) {
						System.out.println("congratulation!.Your shop was approved.");
						return;
					} else if (status == 0) {
						System.out.println("Sorry!.Your shop was denied.please check terms and conditions");
						return;
					}
				}
			}
		}

		else {
			System.out.println("Your shop was deleted or does not exist!");

		}

	}

	public void deleteShop(String shopId) {
		if (Admin.shops.containsKey(shopId)) {
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

	public void setMyShop(Shop myShop) {
		this.myShop = myShop;
	}

	public String toString() {
		return "\nSeller Id: " + this.sellerID + "\nShop Name: " + this.shopName + "\nShop address: " + this.shopAddress
				+ super.toString();
	}
}

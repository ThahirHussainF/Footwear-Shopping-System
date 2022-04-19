
package com.shop;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
//It is used to perform all operations for sellers
public class Seller extends User {
	static byte id = 1;
	private String sellerID;
	private String shopName;
	private String shopAddress;
	private String password;
	private String userName;
	private Shop myShop;//It will store shop object for each seller.
	Scanner scanner = new Scanner(System.in);
	public Seller() {
		//this.userDetails();
//		System.out.println("Enter the shop name: ");
//		this.shopName = scanner.nextLine();
//		System.out.println("Enter the shop address: ");
//		this.shopAddress = scanner.nextLine();
		Date d = new Date();
		this.sellerID = "BS" + (d.getYear() + 1900) + "S" + id++;
		Notification.sellerNotifications.put(this.getSellerID(), new Stack<String>());
	}
	//It is used to show the menu for all operations related to Seller.
	public void menu(Notification notification) {
		boolean exit = true;
		System.out.println("***************Home*********************");
		do {
			System.out.println(
					"\n1.Creating my new Shop\n2.Check the status of my shop\n3.Accept or deny order"
					+"\n4.Add the product\n5.update the product\n6.delete the product"
					+ "\n7.Print the products\n8.Accept or deny cancellation request\n9.Deleting my Shop"
					+"\n10.Notifications\n11.Logout\nEnter your choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				this.createShop();
				break;
			case 2:
				this.checkStatusOfTheShop();
				break;
			case 3:
				this.myShop.acceptOrDenyOrder();
				break;
			case 4:
				this.myShop.addProductToShop();;
				break;
			case 5:
				this.myShop.updateProductToShop();
				break;
			case 6:
				this.myShop.removeProductFromShop();
				break;
			case 7:
				this.myShop.printProducts();;
				break;
			case 8:
				this.myShop.performCancellation();
				break;
			case 9:
				this.deleteShop();
				break;
			case 10:
				notification.notificationMenuForSeller(this.getSellerID());
				break;
			case 11:
				exit = false;
				break;
			}

		} while (exit);
	}

	//It is used to create the shop for each seller object.
	public void createShop() {
		Shop shop = new Shop();
		shop.setOwnerName(this.firstName + " " + this.lastName);
		shop.setSeller(this);
		shop.setShopName(shopName);
		this.setMyShop(shop);
		Accounts.shops.put(this.getSellerID(), shop);
		Admin.approvalOrRejectionOfShops(shop);
		System.out.println(this.myShop.toString());
		System.out.println("please waiting for approval from admin...........");
		
	}
	//It is used to create the shop for each seller object.
	public void checkStatusOfTheShop() {
		if (this.myShop == null) {
			System.out.println("There is no shop linked with this account!");
			return;
		}
		if (Accounts.shops.containsKey(this.getSellerID())) {
			Shop shop = Accounts.shops.get(this.sellerID);
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
	//It is used to delete the shop for each seller object.
	public void deleteShop() {
		System.out.println("Enter the shopId to delete");
		String shopId = scanner.next();
		if (Accounts.shops.containsKey(this.getSellerID())) {
			if(Accounts.shops.get(this.getSellerID()).getShopStatus()==0) {
				System.out.println("Your shop was not yet approved.You can't delete the shop.");
				return;
			}
			Admin.approvalQueueforDeletingShop.add(shopId);
			System.out.println("let us contact you as soon as possible......");
		} else {
			System.out.println("There is no shop present for this account!");
		}

	}
	
    //It is used to get the password from every seller object.
	public String getPassword() {
		return password;
	}
	//It is used to set the password to every seller object.
	public void setPassword(String password) {
		this.password = password;
	}
	//It is used to set the password to every seller object.
	public String getUserName() {
		return userName;
	}
	//It is used to set the user name to every seller object.
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//It is used to get the seller Id from every seller object.
	public String getSellerID() {
		return sellerID;
	}
	//It is used to set the seller Id to every seller object.
	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}
    //It is used to get the shop name from every seller object.
	public String getShopName() {
		return shopName;
	}
	 //It is used to set the shop name to every seller object
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	//It is used to get the shop address from every seller object.
	public String getShopAddress() {
		return shopAddress;
	}
	//It is used to set the shop address to every seller object.
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	//I am using compile time polymorphism .
    //It is used to get the shop object from every seller object
	public Shop getMyShop() {
		return myShop;
	}
	//It is used to get the shop object from every seller object
	public Shop getMyShop(String sellerId) {
		return myShop;
	}
	//It is used to set the shop object to every seller object
	public void setMyShop(Shop myShop) {
		this.myShop = myShop;
	}
	//It was used to print details whenever we print seller object.
	public String toString() {
		return "\nSeller Id: " + this.sellerID + "\nShop Name: " + this.shopName + "\nShop address: " + this.shopAddress
				+ super.toString();
	}
}


package com.shop;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Stack;
//It is used to perform all operations for sellers
public class Seller extends User {
	static byte id = 1;
	private String sellerID;//It stores seller Id.
	private String shopName;//It stores shop name.
	private String shopAddress;//It stores shop address.
	private String password;//It stores password.
	private String userName;//It stores user name.
	private Shop myShop=null;//It will store shop object for each seller.
	Scanner scanner = new Scanner(System.in);
	//It has invoked whenever new seller was registered.
	public Seller() {
		this.getUserDetails();
		System.out.println("Enter the shop name: ");
		this.shopName = scanner.nextLine();
		System.out.println("Enter the shop address: ");
		this.shopAddress = scanner.nextLine();
		this.sellerID = "BS" + Calendar.getInstance().get(Calendar.YEAR) + "S" + id++;
		Storage.sellerNotifications.put(this.getSellerID(), new Stack<String>());
	}
	//It is used to show the menu for all operations related to Seller.
	public void showSellerMenu(Notification notification) {
		boolean exit = true;
		System.out.println("***************Home*********************");
		do {
			System.out.println(
					"\n1.Creating my new Shop\n2.Check the status of my shop\n3.Accept or deny order"
					+"\n4.Add the product\n5.update the product\n6.delete the product"
					+ "\n7.Print the products\n8.Accept or deny cancellation request\n9.Deleting my Shop"
					+"\n10.Notifications\n11.Logout");
			int choice =  Security.validateChoice();
			switch (choice) {
			//create new shop
			case 1:
				this.createShop();
				break;
			//check the status of the shop.	
			case 2:
				this.checkStatusOfTheShop();
				break;
			//accept or deny order. 	
			case 3:
				if(!this.isShopExist(this.myShop)) break;
				if(!this.isActiveShop()) break;
				this.myShop.acceptOrDenyOrder();
				break;
			//Add product to shop.	
			case 4:
				if(!this.isShopExist(this.myShop)) break;
				if(!this.isActiveShop()) break;
				this.myShop.addProductToShop();;
				break;
			//Update product to shop.	
			case 5:
				if(!this.isShopExist(this.myShop)) break;
				if(!this.isActiveShop()) break;
				this.myShop.updateProductToShop();
				break;
			//remove product from shop.	
			case 6:
				if(!this.isShopExist(this.myShop)) break;
				if(!this.isActiveShop()) break;
				this.myShop.removeProductFromShop();
				break;
			//print the products	
			case 7:
				if(!this.isShopExist(this.myShop)) break;
				if(!this.isActiveShop()) break;
				this.myShop.printProducts();;
				break;
			//perform cancellation	
			case 8:
				if(!this.isShopExist(this.myShop)) break;
				if(!this.isActiveShop()) break;
				this.myShop.performCancellation();
				break;
			//delete the shop	
			case 9:
				this.deleteShop();
				break;
			//Notification bar	
			case 10:
				notification.showNotificationMenuForSeller(this.getSellerID());
				break;
			//exit condition	
			case 11:
				exit = false;
				break;
			//Invalid choice	
			default:
				System.out.print("Please enter the valid choice!");
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
		Storage.shopsMap.put(this.getSellerID(), shop);
		Admin.approvalQueueforCreatingShop.add(shop);
		System.out.println(this.myShop.toString());
		System.out.println("please waiting for approval from admin...........");
		
	}
	//check if shop is exist or not 
	boolean isShopExist(Shop myShop) {
		if(myShop==null) {
			System.out.println("Shop does not exist!");
			return false;
		}
		return true;
	}
	//It is used to create the shop for each seller object.
	public void checkStatusOfTheShop() {
		if (this.myShop == null) {
			System.out.println("There is no shop linked with this account!");
			return;
		}
		if (Storage.shopsMap.containsKey(this.getSellerID())) {
			Shop shop = Storage.shopsMap.get(this.sellerID);
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
		if (Storage.shopsMap.containsKey(this.getSellerID())) {
			Admin.approvalQueueforDeletingShop.add(shopId);
			System.out.println("let us contact you as soon as possible......");
		} else {
			System.out.println("There is no shop present for this account!");
		}

	}
	//It is used to check whether the shop is active or not.
	public boolean isActiveShop() {
		if(this.myShop.getShopStatus()==1) {
			return true;
		}
		System.out.println("Your shop was not yet approved by admin!");
		return false;
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
	//It was used to print seller details whenever we print seller object.
	public String toString() {
		return "\nSeller Id: " + this.sellerID + "\nShop Name: " + this.shopName + "\nShop address: " + this.shopAddress
				+ super.toString();
	}
}

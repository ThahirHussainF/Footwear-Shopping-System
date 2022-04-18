/*
 * Application title : Online Footwear Shopping system
 * Author            : F.Thahir Hussain
 * Created on        : April 9 2022
 * Last Modified date: April 18 2022
 * Reviewed by       :
 * Suggestions       :
 */
package com.shop;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
//It is used to perform all operations for customer.
public class Customer extends User {
	private static byte id = 1;
	private String customerId;
	private String userName;
	private String password;
	Map<String,Cart> cartMap=new HashMap<>();
    Scanner scanner=new Scanner(System.in);

	
	public Customer() {
		//super();
		Date d = new Date();
		this.customerId = "BS" + (d.getYear() + 1900) + "C" + id++;
		Notification.customerNotifications.put(this.getCustomerId(),new Stack<String>());
	}
	//It is used to show the menu for all operations related to customer.
	public void menu(Notification notification) {
		boolean exit = true;
		System.out.println("***************Home*********************");
		do {
			System.out.println("\n1.Add to cart\n2.Make Purchase\n3.Check the order details\n4.Cancel the order\n5.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				this.addToCart();
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				notification.notificationMenuForCustomer(this.getCustomerId());
				break;
			case 5:
				exit = false;
				break;
			}

		} while (exit);
	}
	public void addToCart() {
		String shopId;
		String productId;
		int footwearSize;
		int noOfFootwear;
		System.out.println("Enter the shop ID: ");
		shopId=scanner.next();
		System.out.println("Entere the product Id: ");
		productId=scanner.next();
		System.out.println("Enter the size and count: ");
		footwearSize=scanner.nextInt();
		noOfFootwear=scanner.nextInt();
		Cart cart=new Cart(shopId,productId,footwearSize,noOfFootwear);
		cartMap.put(productId, cart);
	}
	public void makePurchase() {
		double amount=0.0;
		for(Cart cart:cartMap.values()) {
			for(Shop shop:Accounts.shops.values()) {
				if(shop.getShopId().equals(cart.shopId)) {
					//amount+=
				}
			}
		}
	}
	public void printCart() {
		System.out.println("Total Number of products to be added to cart");
		for(Cart cart:cartMap.values()) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println(cart);
			System.out.println("-----------------------------------------------------------------");
		}
	}
    //It is used to get the customer Id.
	public String getCustomerId() {
		return customerId;
	}
    //It is used to set the customer Id
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	//It is used to get the user name.
	public String getUserName() {
		return userName;
	}
	//It is used to set the user name.
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//It is used to get the password.
	public String getPassword() {
		return password;
	}
	//It is used to set the password.
	public void setPassword(String password) {
		this.password = password;
	}

	@Override //It was used to print details whenever we print customer object.
	public String toString() {
		return "\nCustomer Id: " + this.customerId +super.toString();
	}

}
//store the product details for buying
	 class Cart {
		String shopId;
		String productId;
		int footwearSize;
		int noOfFootwear;
		public Cart(String shopId, String productId, int footwearSize, int noOfFootwear) {
			this.shopId = shopId;
			this.productId = productId;
			this.footwearSize = footwearSize;
			this.noOfFootwear = noOfFootwear;
		}
		@Override
		public String toString() {
			return "\nShop Id =" + shopId + "\nProduct Id =" + productId + "\nFootwear size =" + footwearSize
					+ "\nnoOfFootwear = " + noOfFootwear;
		}
		
	}

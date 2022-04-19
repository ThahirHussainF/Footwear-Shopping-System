
package com.shop;

import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Date;

//It is used to perform all operations related to Shop.
public class Shop {
	private static byte id = 1;
	private String shopId;
	private String shopName;
	private String ownerName;
	private Seller seller;
	private int shopStatus = 0;// 0 means not yet approval by admin, 1 means approval by admin, 2 mean denied
								// by admin
	boolean oneTimeCalling = true;
	Map<String, Product> productMap = new HashMap<>();
	Queue<Order> receivedOrders = new LinkedList<>();
	Scanner scanner = new Scanner(System.in);

	public Shop() {
		Date date = new Date();
		this.shopId = "BS" + (date.getYear() + 1900) + "SHOP" + id++;
	}

	// It is used to add product to Shop object.
	public void addProductToShop() {
		Product product = new Product();
		productMap.put(product.getProductId(), product);
		System.out.println("Product " + product.getProductId() + " was added successfully!");
	}

	// It is used to add product to Shop object.
	public void addProductToShop(Product product) {
		productMap.put(product.getProductId(), product);
	}

	// It is used to remove product from Shop object.
	public void removeProductFromShop() {
		String productId;
		do {
			System.out.println("Enter the Product Id: ");
			productId = scanner.next();
			if (productMap.containsKey(productId)) {
				break;
			}
			System.out.println("Invalid product Id!");
		} while (true);
		for (Product product : productMap.values()) {
			if (product.getProductId().equals(productId)) {
				productMap.remove(productId);
			}
		}
		System.out.println("Product " + productId + " was removed successfully!");

	}

	// It is used to update product details
	public void updateProductToShop() {

		String productId;
		productId = scanner.next();
		do {
			System.out.println("Enter the Product Id: ");
			productId = scanner.next();
			if (productMap.containsKey(productId)) {
				break;
			}
			System.out.println("Invalid product Id!");
		} while (true);
		for (Product product : productMap.values()) {
			if (product.getProductId().equals(productId)) {
				boolean exit = true;
				do {
					System.out.println("which do you want to update?");
					System.out.println("\n1.Product Name\n2.Product Price\n3.Update the count for each size\n4.Exit");
					int choice;
					System.out.println("Enter your choice: ");
					Scanner scanner = new Scanner(System.in);
					choice = scanner.nextInt();
					switch (choice) {
					case 1:
						String productName;
						System.out.println("Enter the Product Name:");
						scanner.nextLine();
						productName = scanner.nextLine();
						product.setProductName(productName);
						break;
					case 2:
						double productPrice;
						System.out.println("Enter the Product Price: ");
						productPrice = scanner.nextDouble();
						product.setPrice(productPrice);
						break;
					case 3:
						int noOfProductsAvailable;
						int size;
						System.out.println("Enter the size and number of Products: ");
						size = scanner.nextInt();
						noOfProductsAvailable = scanner.nextInt();
						product.getEachSizeWithTheirCount().put(size, noOfProductsAvailable);
						break;
					case 4:
						exit = false;
						break;

					}
				} while (exit);

			}
		}
		System.out.println("Product " + productId + " was updated successfully!");

	}

	// It is used to print products for each shop.
	public void printProducts() {
		for (Product product : productMap.values()) {
			if (!productMap.isEmpty()) {
				System.out.println("\n***********************************************************");
				System.out.println(product);
				System.out.println("\n***********************************************************");
			}
		}
	}

	public void loadOrder() {
		for (Order order : Accounts.orders.values()) {
			if (order.getSellerId().equals(this.getSeller().getSellerID())) {
				this.receivedOrders.add(order);
			}
		}

	}

	public void acceptOrDenyOrder() {
		if (this.oneTimeCalling) {
			loadOrder();
			this.oneTimeCalling = false;
		}
		if (this.receivedOrders.isEmpty()) {
			System.out.println("There were no orders!");
			return;
		}
		for (Order order : this.receivedOrders) {
			System.out.println(order);
			byte choice;
			System.out.println("\n1.Accept\n2.Deny\nEnter your choice: ");
			choice = scanner.nextByte();
			if (choice == 1) {
				order.setOrderStatus(choice);
				System.out.println("Order was accepted successfully!");
			} else {
				order.setOrderStatus(choice);
				System.out.println("Order was denied successfully!");
			}
			receivedOrders.remove();
		}
	}

	public void performCancellation() {
          for(Order order:Accounts.orders.values()) {
        	  if(order.getCancellingOrderStatus()==1) {
        		System.out.println(order);  
        		byte choice;
      			System.out.println("\n2.Accept\n3.Deny\nEnter your choice: ");
      			choice = scanner.nextByte();
      			if(choice==2) {
      				order.setOrderStatus((byte)2);
      				order.setCancellingOrderStatus(choice);
      				Accounts.orders.remove(order.getOrderId());
      				System.out.println("Cancelling request was accepted!");
      				return;
      			}
      			else {
      				order.setCancellingOrderStatus(choice);
      				System.out.println("Cancelling request was denied!");
      				return;
      			}
        	  }
          }
          System.out.println("There is no order for cancellation!");
	}

	// It is used to get shop Id from Shop object.
	public String getShopId() {
		return shopId;
	}

	// It is used to set shop Id to Shop object.
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	// It is used to get the shop name from shop object.
	public String getShopName() {
		return shopName;
	}

	// It is used to set the shop name to shop object.
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	// It is used to get the owner of shop from shop object.
	public String getOwnerName() {
		return ownerName;
	}

	// It is used to set the owner of shop to shop object.
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	// It is used to get the status of the shop from shop object.
	public int getShopStatus() {
		return shopStatus;
	}

	// It is used to set the status of the shop to shop object.
	public void setShopStatus(int shopStatus) {
		this.shopStatus = shopStatus;
	}

	// It is used to get the seller object for corresponding shop object.
	public Seller getSeller() {
		return seller;
	}

	// It is used to get the seller object for corresponding shop Id.
	public Seller getSeller(String shopId) {
		return seller;
	}

	// It is used to set the seller object to corresponding shop object.
	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	// It was used to print details whenever we print shop object.
	public String toString() {
		return "\n*****************Shop Details*****************\n" + "\nShop ID: " + this.shopId + "\nShop Name: "
				+ this.shopName + "\nSeller Name: " + this.ownerName + "\nSeller ID: " + this.seller.getSellerID()
				+ "\nShop Status: " + this.shopStatus + "(0->Not yet approved, 1-> Approved, 2->Denied)"
				+ "\n*****************Seller Details*****************\n" + this.seller.toString();
	}

}

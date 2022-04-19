
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
	Map<String, Cart> cartMap = new HashMap<>();
	Stack<Order> myOrders = new Stack<>();
	Scanner scanner = new Scanner(System.in);

	public Customer() {
		// super();
		Date d = new Date();
		this.customerId = "BS" + (d.getYear() + 1900) + "C" + id++;
		Notification.customerNotifications.put(this.getCustomerId(), new Stack<String>());
	}

	// It is used to show the menu for all operations related to customer.
	public void menu(Notification notification) {
		boolean exit = true;
		System.out.println("***************Home*********************");
		do {
			System.out.println(
					"\n1.Add product to cart\n2.Print products from cart\n3.Remove Product from cart\n4.Make Purchase\n5.Check the order status\n6.Cancel the order\n7.Notifications\n8.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				this.addProductToCart();
				break;
			case 2:
				this.printProductsFromCart();
				break;
			case 3:
				this.removeProductFromCart();
				break;
			case 4:
				this.makePurchase();
				break;
			case 5:
				this.checkOrderStatus();
				break;
			case 6:
				this.cancelOrder();
				break;
			case 7:
				notification.notificationMenuForCustomer(this.getCustomerId());
				break;
			case 8:
				exit = false;
				break;
			}

		} while (exit);
	}

	public void addProductToCart() {
		String shopId;
		String productId;
		int footwearSize;
		int noOfFootwear;
		Shop validProductId = null;// checking vaild product id
		boolean set=true;// checking vaild details
		while (true) {
			System.out.println("Enter the shop ID: ");
			shopId = scanner.next();
			for (Shop shop : Accounts.shops.values()) {
				if (shop.getShopId().equals(shopId)) {
					validProductId = shop;
					set = false;
					break;
				}
			}
			if (!set) {
				break;
			} else {
				System.out.println("You entered wrong Shop Id.Try again!");
			}
		}
		while (true) {
			System.out.println("Entere the product Id: ");
			productId = scanner.next();
			if (validProductId.productMap.containsKey(productId)) {
				break;
			}
			System.out.println("You entered wrong Product Id.Try again!");
		}

		System.out.println("Enter the size and count: ");
		footwearSize = scanner.nextInt();
		noOfFootwear = scanner.nextInt();
		Cart cart = new Cart(shopId, productId, footwearSize, noOfFootwear, this.customerId);
		cart.setAmount(this.priceCalculation(cart));
		cartMap.put(cart.getCartId(), cart);
		System.out.println("Product was added to cart sucessfully!");
	}

	public void removeProductFromCart() {
		if (cartMap.isEmpty()) {
			System.out.println("No items were added to cart!");
			return;
		}
		printProductsFromCart();
		System.out.println("Enter the cart Id to be orderd: ");
		String cartId = scanner.next();
		if (!this.cartMap.containsKey(cartId)) {
			System.out.println("You entered wrong cart id!");
			return;
		}
		for (Cart cart : this.cartMap.values()) {
			if (cart.getCartId().equals(cartId)) {
				cartMap.remove(cartId);
				System.out.println("Product was removed from cart successfully!");
				break;
			}
		}
	}

	public double priceCalculation(Cart cart) {
		double amount = 0.0;
		for (Shop shop : Accounts.shops.values()) {
			if (shop.getShopId().equals(cart.getShopId())) {
				for (Product product : shop.productMap.values()) {
					if (product.getProductId().equals(cart.getProductId())) {
						amount += (product.getPrice() * cart.getNoOfFootwear());
					}
				}
			}
		}
		return amount;
	}

	public void makePurchase() {
		if (cartMap.isEmpty()) {
			System.out.println("No items were added to cart!");
			return;
		}
		printProductsFromCart();
		Order order = new Order();
		System.out.println("Enter the cart Id to be orderd: ");
		String cartId = scanner.next();
		if (!this.cartMap.containsKey(cartId)) {
			System.out.println("You entered wrong cart id!");
			return;
		}
		for (Cart cart : this.cartMap.values()) {
			if (cart.getCartId().equals(cartId)) {
				order.addOrder(cart);
				break;
			}
		}
		Accounts.orders.put(order.getOrderId(), order);
		System.out.println("You product was orderd sucessfully!");
		this.cartMap.remove(cartId);
		this.myOrders.add(order);

	}

	public void printProductsFromCart() {
		if (cartMap.isEmpty()) {
			System.out.println("No items were present!");
			return;
		}
		System.out.println("Total Number of products to be added to cart");
		for (Cart cart : cartMap.values()) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println(cart);
			System.out.println("-----------------------------------------------------------------");
		}
	}

	public void checkOrderStatus() {
		if (this.myOrders.isEmpty()) {
			System.out.println("There is no order!");
		}
		for (Order order : this.myOrders) {
			if(order.getCancellingOrderStatus()==0) {
				if (order.getOrderStatus() == 0) {
					System.out.println(order + "\nRemark: " + "Your order is not yet viewed by seller!");
				} else if (order.getOrderStatus() == 1) {
					System.out.println(order + "\nRemark: " + "Your order was acceptd!");
				} else {
					System.out.println(order + "\nRemark: " + "Your order was denied!");
				}
			}
			else {
				if(order.getCancellingOrderStatus()==1) {
					System.out.println(order + "\nRemark: " + "Your cancelling request is not yet viewed by seller!");
				}else if(order.getCancellingOrderStatus()==2) {
					System.out.println(order + "\nRemark: " + "Your cancelling request was accepted!");
				} else if(order.getCancellingOrderStatus()==3) {
					System.out.println(order + "\nRemark: " + "Your cancelling request was denied!");
				}
			}
		}
	}
   public void cancelOrder() {
	   int count=3;//avoiding infinite loop
	   if(myOrders.isEmpty()) {
		   System.out.println("You did not order any products!");
		   return;
	   }
	   for(Order order:myOrders) {
		   System.out.println(order);
	   }
	   while(count!=0) {
		   String orderId;
		   System.out.println("Enter the order ID: ");
		   orderId=scanner.next();
		 
		   if(Accounts.orders.containsKey(orderId)) {
			   Order order=Accounts.orders.get(orderId);
			  if(order.getCancellingOrderStatus()==1) {
				   System.out.println("Your request was already sent to seller!");
				   return;
			   }
			   order.setCancellingOrderStatus((byte)1);
			   System.out.println("Your request was sent to seller!.");
			   break;
		   }
		   System.out.println("You entered wrong order Id!");
		   count--;
	   }
   }
	// It is used to get the customer Id.
	public String getCustomerId() {
		return customerId;
	}

	// It is used to set the customer Id
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	// It is used to get the user name.
	public String getUserName() {
		return userName;
	}

	// It is used to set the user name.
	public void setUserName(String userName) {
		this.userName = userName;
	}

	// It is used to get the password.
	public String getPassword() {
		return password;
	}

	// It is used to set the password.
	public void setPassword(String password) {
		this.password = password;
	}

	@Override // It was used to print details whenever we print customer object.
	public String toString() {
		return "\nCustomer Id: " + this.customerId + super.toString();
	}

}

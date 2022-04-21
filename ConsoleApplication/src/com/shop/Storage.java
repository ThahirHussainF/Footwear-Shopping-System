package com.shop;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.HashMap;
//It manages the all accounts(customer, seller, admin).
final class Storage {
  //It is used to store all objects which is customer,seller,admin.	
  	
  static List<Customer> customersList=new ArrayList<>();
  static List<Seller> sellersList=new ArrayList<>();
  static List<Admin> adminsList=new ArrayList<>();
  static Map<String,Customer> customersMap=new HashMap<>();//It is used to store user name and their object for customer
  static Map<String,Seller> sellersMap=new HashMap<>();//It is used to store user name and their object for customer seller.
  static Map<String,Admin> adminsMap=new HashMap<>();//It is used to store user name and their object for customer admin.
  static Map<String, Shop> shopsMap= new HashMap<>();//which is used to store seller Id with corresponding shop object.
  static Map<String,Order> ordersMap=new HashMap<>();//which is used to keep track the orders.
  static Map<String, Stack<String>> customerNotifications = new HashMap<>();//Which stores customer Id with their notifications.
  static Map<String, Stack<String>> sellerNotifications = new HashMap<>();//Which stores seller Id with their notifications.
  static Map<String, Stack<String>> adminNotifications = new HashMap<>();//Which stores admin Id with their notifications.
  //for testing purpose
  public static void test() {
//	  Customer customer=new Customer();
//	  customer.setUserName("Customer123");
//	  customer.setPassword("Customer@123");
//	  Seller seller=new Seller();
//	  seller.setShopName("Bismi Shoe Mart");
//	  seller.setShopAddress("Sholavandhan");
//	  seller.setUserName("Seller123");
//	  seller.setPassword("Seller@123");
//	  Shop shop=new Shop();
//	  shops.put(seller.getSellerID(),shop);
//	  seller.setMyShop(shop);
//	  shop.setShopName(seller.getShopName());
//	  shop.setShopStatus(1);
//	  shop.setSeller(seller);
//	  Map<Integer, Integer> sizeWithCountMap=new HashMap<>();
//	  sizeWithCountMap.put(6,4);
//	  sizeWithCountMap.put(7,5);
//	  sizeWithCountMap.put(8,6);
//	  Product product1=new Product("pride","MALE","VKC",sizeWithCountMap,123.45);
//	  Product product2=new Product("Lite","FEMALE","VKC",sizeWithCountMap,567.45);
//	  Product product3=new Product("walkaroo","FEMALE","VKC",sizeWithCountMap,897.45);
//	  Product product4=new Product("leeds","CHILDMALE","VKC",sizeWithCountMap,100.45);
//	  Product product5=new Product("cubix","CHILDFMALE","VKC",sizeWithCountMap,56.45);
//	  Product product6=new Product("hi-tech","BABY","VKC",sizeWithCountMap,56.45);
//	  shop.addProductToShop(product1);
//	  shop.addProductToShop(product2);
//	  shop.addProductToShop(product3);
//	  shop.addProductToShop(product4);
//	  shop.addProductToShop(product5);
//	  shop.addProductToShop(product6);
//	  Admin admin=new Admin();
//	  admin.setUsername("Admin123");
//	  admin.setPassword("Admin@123");
//	  sellers.add(seller);
//	  admins.add(admin);
//	  customers.add(customer);
//	  customersMap.put(customer.getUserName(), customer.getPassword());
//	  sellersMap.put(seller.getUserName(),seller.getPassword());
//	  adminMap.put(admin.getUsername(),admin.getPassword());
  }

//It is used to add user name and password to corresponding list and also add user name and their object into corresponding map.
	public static void addUser(String user, String userName, String password) {
		if (user.equals("customer")) {
			Customer customer = new Customer();
			customer.setUserName(userName);
			customer.setPassword(password);
			customersList.add(customer);
			customersMap.put(customer.getUserName(), customer);
			System.out.println("Your customer Id  was "+customer.getCustomerId());
		} else if (user.equals("seller")) {
			Seller seller = new Seller();
			seller.setUserName(userName);
			seller.setPassword(password);
			sellersList.add(seller);
			sellersMap.put(seller.getUserName(),seller);
			System.out.println("Your seller Id  was "+seller.getSellerID());
		} else if (user.equals("admin")) {
			Admin admin = new Admin();
			admin.setUsername(userName);
			admin.setPassword(password);
			 adminsList.add(admin);
			 adminsMap.put(admin.getUsername(), admin);
			System.out.println("Your admin Id  was "+admin.getAdminId());
		}
		System.out.println("Account was created successfully!!!");
	} 
	

}
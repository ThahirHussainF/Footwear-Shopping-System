package com.shop;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
//It manages the all accounts(customer, seller, admin).
class Accounts {
  //It is used to store all objects which is customer,seller,admin.	
  static List<Customer> customers=new ArrayList<>();
  static List<Seller> sellers=new ArrayList<>();
  static List<Admin> admins=new ArrayList<>();
  static Map<String,String> customersMap=new HashMap<>();//It is used to store username and password for customer.
  static Map<String,String> sellersMap=new HashMap<>();//It is used to store username and password for seller.
  static Map<String,String> adminMap=new HashMap<>();//It is used to store username and password for admin.
  static Map<String, Shop> shops = new HashMap<>();//which is used to store seller Id with corresponding shop object.

  //for testing purpose
  public void test() {
	  Seller seller=new Seller();
	  seller.setShopName("Bismi Shoe Mart");
	  seller.setShopAddress("Sholavandhan");
	  seller.setUserName("Seller@123");
	  seller.setPassword("Seller@123");
	  Shop shop=new Shop();
	  shops.put(seller.getSellerID(),shop);
	  seller.setMyShop(shop);
	  shop.setShopName(seller.getShopName());
	  shop.setShopStatus(1);
	  Map<Integer, Integer> sizeWithCountMap=new HashMap<>();
	  sizeWithCountMap.put(6,4);
	  sizeWithCountMap.put(7,5);
	  sizeWithCountMap.put(8,6);
	  Product product1=new Product("pride","MALE","VKC",sizeWithCountMap,123.45);
	  Product product2=new Product("Lite","FEMALE","VKC",sizeWithCountMap,567.45);
	  Product product3=new Product("walkaroo","FEMALE","VKC",sizeWithCountMap,897.45);
	  Product product4=new Product("leeds","CHILDMALE","VKC",sizeWithCountMap,100.45);
	  Product product5=new Product("cubix","CHILDFMALE","VKC",sizeWithCountMap,56.45);
	  Product product6=new Product("hi-tech","BABY","VKC",sizeWithCountMap,56.45);
	  shop.addProductToShop(product1);
	  shop.addProductToShop(product2);
	  shop.addProductToShop(product3);
	  shop.addProductToShop(product4);
	  shop.addProductToShop(product5);
	  shop.addProductToShop(product6);
	  Admin admin=new Admin();
	  admin.setUsername("Admin@123");
	  admin.setPassword("Admin@123");
	  sellers.add(seller);
	  admins.add(admin);
	  sellersMap.put(seller.getUserName(),seller.getPassword());
	  adminMap.put(admin.getUsername(),admin.getPassword());
  }
  //It is used to add customer object to customers list.
  public void addCustomerToSystem(Customer customer) {
   customers.add(customer);
   customersMap.put(customer.getUserName(), customer.getPassword());
  }
  //It is used to add seller object to sellers list.
  public void addSellerToSystem(Seller seller) {
	   sellers.add(seller);
	   sellersMap.put(seller.getUserName(), seller.getPassword());
	   
	  }
  //It is used to add admin object to admins list.
  public void addAdminToSystem(Admin admin) {
	  admins.add(admin);
	  adminMap.put(admin.getUsername(), admin.getPassword());
  }
  //It is check user credentials for all users.
  public boolean checkValidUser(String user,String username, String password) {
	  if(user.equals("customer")&&customersMap.get(username).compareTo(password)==0) return true;
	  else if(user.equals("seller")&&sellersMap.get(username).compareTo(password)==0) return true;
	  else if(user.equals("admin")&&adminMap.get(username).compareTo(password)==0) return true;
	  return false;
  }
 
}
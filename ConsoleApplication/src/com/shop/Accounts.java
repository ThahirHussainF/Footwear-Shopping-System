package com.shop;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
class Accounts {
  static List<Customer> customers=new ArrayList<>();
  static List<Seller> sellers=new ArrayList<>();
  static List<Admin> admins=new ArrayList<>();
  static Map<String,String> customersMap=new HashMap<>();
  static Map<String,String> sellersMap=new HashMap<>();
  static Map<String,String> adminMap=new HashMap<>();
  public void addCustomerToSystem(Customer customer) {
   customers.add(customer);
   customersMap.put(customer.getUserName(), customer.getPassword());
  }
  public void addSellerToSystem(Seller seller) {
	   sellers.add(seller);
	   sellersMap.put(seller.getUserName(), seller.getPassword());
	   
	  }
  public void addAdminToSystem(Admin admin) {
	  admins.add(admin);
	  adminMap.put(admin.getUsername(), admin.getPassword());
  }
  public boolean checkValidUser(String user,String username, String password) {
	  if(user.equals("customer")&&customersMap.get(username).compareTo(password)==0) return true;
	  else if(user.equals("seller")&&sellersMap.get(username).compareTo(password)==0) return true;
	  else if(user.equals("admin")&&adminMap.get(username).compareTo(password)==0) return true;
	  return false;
  }
 
}
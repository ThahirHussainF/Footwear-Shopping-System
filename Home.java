
package com.shop;
//It is used to go home page for corresponding user after the login operation is performed.
public class Home {
    Notification notification=new Notification();//It is used to create notification object for all users.
    //It has invoked whenever user has login successfully.
    public Home(String user,String username) {
    	switch(user) {
    	//Customer home page
    	case "customer":
    		for(Customer customer:Storage.customersList) {
    			if(customer.getUserName().equals(username)) {
    				customer.showCustomerMenu(notification);
    				break;
    			}
    		}
    	  break;
    	//Seller home page 
    	case "seller":
    		for(Seller seller:Storage.sellersList) {
    			if(seller.getUserName().equals(username)) {
    				seller.showSellerMenu(notification);
    				break;
    			}
    		}
    		break;
    	//Admin home page	
    	case "admin":
    		for(Admin admin:Storage.adminsList) {
    			if(admin.getUsername().equals(username)) {
    				admin.showAdminMenu(notification);
    				break;
    			}
    		}
    	   break;
    		
    	}
    	System.out.println("Logout Successfully!");
    }
}

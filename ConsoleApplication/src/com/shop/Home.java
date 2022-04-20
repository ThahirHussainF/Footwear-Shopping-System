
package com.shop;
//It is used to go home page for corresponding user after the login operation is performed.
public class Home {
    private String user;
    Notification notification=new Notification();//It is used to create notification object for all user objects.
    public Home(String user,String username,Storage account) {
    	switch(user) {
    	case "customer":
    		for(Customer customer:account.customers) {
    			if(customer.getUserName().equals(username)) {
    				customer.menu(notification);
    				break;
    			}
    		}
    	  break;
    	case "seller":
    		for(Seller seller:account.sellers) {
    			if(seller.getUserName().equals(username)) {
    				seller.menu(notification);
    				break;
    			}
    		}
    		break;
    	case "admin":
    		for(Admin admin:account.admins) {
    			if(admin.getUsername().equals(username)) {
    				admin.menu(notification);
    				break;
    			}
    		}
    	   break;
    		
    	}
    	System.out.println("Logout Successfully!");
    }
}

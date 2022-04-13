package com.shop;

public class Home {
    private String user;
    Notification notification=new Notification();
    public Home(String user,String username,Accounts account) {
    	switch(user) {
    	case "customer":
    		//on progress
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

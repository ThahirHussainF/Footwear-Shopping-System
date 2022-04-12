package com.shop;

public class Home {
    private String user;
    Accounts account=new Accounts();
    public Home(String user,String username) {
    	switch(user) {
    	case "customer":
    		//on progress
    	  break;
    	case "seller":
    		for(Seller seller:account.sellers) {
    			if(seller.getUserName().equals(username)) {
    				seller.menu();
    				break;
    			}
    		}
    		break;
    	case "admin":
    		for(Admin admin:account.admins) {
    			if(admin.getUsername().equals(username)) {
    				admin.menu();
    				break;
    			}
    		}
    	   break;
    		
    	}
    	System.out.println("Logout Successfully!");
    }
}

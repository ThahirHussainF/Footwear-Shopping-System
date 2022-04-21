package com.shop;

//It is used to show the welcome page of the application which will contains all shops with their products and also login menu.
public class WelcomePage {
    public WelcomePage(Storage storage){
    	
    	System.out.println("*************************************************************************************");
    	System.out.println("***********************"+"WELCOME TO BISMI FOOTWEAR MART"+"********************************");
    	System.out.println("*************************************************************************************");
    	for(Shop shop:Storage.shopsMap.values()) {
    		System.out.println("----------------------"+shop.getShopName()+"--------------------------------------");
    		System.out.println("SHOP ID:"+shop.getShopId());
    			shop.printProducts();
    		System.out.println("----------------------------------------------------------------------------------");
    	}
    	new Loginpage(storage);//Go to Login Page
    }
}

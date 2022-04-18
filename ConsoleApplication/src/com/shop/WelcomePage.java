package com.shop;

public class WelcomePage {
    public WelcomePage() {
    	Accounts account=new Accounts();
    	account.test();
    	System.out.println("*************************************************************************************");
    	System.out.println("***********************"+"WELCOME TO BISMI FOOTWEAR MART"+"********************************");
    	System.out.println("*************************************************************************************");
    	for(Shop shop:Accounts.shops.values()) {
    		System.out.println("----------------------"+shop.getShopName()+"--------------------------------------");
    		System.out.println("SHOP ID:"+shop.getShopId());
    			shop.printProducts();
    		System.out.println("----------------------------------------------------------------------------------");
    	}
    	new Management(account);
    }
}

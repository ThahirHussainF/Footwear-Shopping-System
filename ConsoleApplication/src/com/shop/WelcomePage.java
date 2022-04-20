package com.shop;

import java.io.IOException;

public class WelcomePage {
    public WelcomePage(Storage account){
    	
    	account.test();
    	System.out.println("*************************************************************************************");
    	System.out.println("***********************"+"WELCOME TO BISMI FOOTWEAR MART"+"********************************");
    	System.out.println("*************************************************************************************");
    	for(Shop shop:Storage.shops.values()) {
    		System.out.println("----------------------"+shop.getShopName()+"--------------------------------------");
    		System.out.println("SHOP ID:"+shop.getShopId());
    			shop.printProducts();
    		System.out.println("----------------------------------------------------------------------------------");
    	}
    	new Management(account);
    }
}


package com.footwearShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
//It is used to store all details related to product.
public class Product {
   private static byte id=1;	
   private String productId;//It stores product Id.
   private String productName;//It stores product name.
   private String category;//It stores product category.
   private String brandName;//It stores brand name.
   public Map<Integer,Integer> eachSizeWithTheirCount=new HashMap<>();//which holds each foot wear size with their count.
   private double price;
   private String review;//product review(*/**/***/****/*****)
   static List<String> comments=new ArrayList<>();//Which stores  comments from customers for this product.
   Scanner scanner=new Scanner(System.in);
   //It was invoked whenever new product was created.
   public Product() {
	  
	  System.out.println("Enter the brand name: ");
	  this.brandName=scanner.next();
	  System.out.println("Enter the Product name: ");
	  scanner.nextLine();
	  this.productName=scanner.nextLine();
	  System.out.println("Enter the Category(MALE,FEMALE,CHILDMALE, CHILDFEMALE,BABY): ");
	  this.category=scanner.nextLine();
	  System.out.println("Enter the count of the products for each size");
	  for(int i=6;i<=12; i++) {
		  System.out.println("\nsize: "+i+" count: ");
		  int getCountfromUser=scanner.nextInt();
		  this.eachSizeWithTheirCount.put(i, getCountfromUser);
	  }
	  System.out.println("Enter the price: ");
	  this.price=scanner.nextDouble(); 
	  this.productId=this.brandName+id++;
	  
   }
//It is used to get the product Id from product object.   
public String getProductId() {
	return productId;
}
//It is used to set product Id to product object.
public void setProductId(String productId) {
	this.productId = productId;
}
//It is used to get the product name from product object.
public String getProductName() {
	return productName;
}
//It is used to set product name to product object.
public void setProductName(String productName) {
	this.productName = productName;
}
//It is used to get the product price from product object.
public double getPrice() {
	return price;
}
//It is used to set the product price to product object.
public void setPrice(double price) {
	this.price = price;
}
//It is used to get the product review from product object.
public String getReview() {
	return review;
}
//It is used to set the product review to product object.
public void setReview(String review) {
	this.review = review;
}
//It is used to get the comments from product object.
public static List<String> getComments() {
	return comments;
}
//It is used to get the category from product object.
public String getCategory() {
	return category;
}
//It is used to set the category to product object.
public void setCategory(String category) {
	this.category = category;
}
//It is used to get the eachSizeWithTheirCount map.
public Map<Integer, Integer> getEachSizeWithTheirCount() {
	return eachSizeWithTheirCount;
}
//It is used to get the brand name from product object.
public String getBrandName() {
	return brandName;
}
//It is used to set the brand name to product object.
public void setBrandName(String brand) {
	this.brandName = brand;
}
@Override
//It is used to print product details whenever we print product object.
public String toString() {
	return "\nproductId=" + productId + "\nproductName=" + productName + "\ncategory=" + category
			+ "\nbrandName=" + brandName + "\neachSizeWithTheirCount=" + eachSizeWithTheirCount.toString() + "\nprice=" + price;
}

   
}

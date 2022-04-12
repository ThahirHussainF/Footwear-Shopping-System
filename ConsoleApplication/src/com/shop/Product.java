package com.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
enum Category{
	   MALE,FEMALE,CHILDMALE, CHILDFEMALE,BABY;
}
public class Product {
   private static int id=1;	
   private int productId;
   private String ProductName;
   private String category;
   public Map<Integer,Integer> eachSizeWithTheirCount=new HashMap<>();
   private double price;
   private String review;
   static List<String> comments=new ArrayList<>();
   public Product() {
	  for(int i=6;i<=12; i++) {
		  this.eachSizeWithTheirCount.put(i, 0);
	  }
   }
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getReview() {
	return review;
}
public void setReview(String review) {
	this.review = review;
}
public static List<String> getComments() {
	return comments;
}
public static void setComments(List<String> comments) {
	Product.comments = comments;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public Map<Integer, Integer> getEachSizeWithTheirCount() {
	return eachSizeWithTheirCount;
}
public void setEachSizeWithTheirCount(Map<Integer, Integer> eachSizeWithTheirCount) {
	this.eachSizeWithTheirCount = eachSizeWithTheirCount;
}

   
}

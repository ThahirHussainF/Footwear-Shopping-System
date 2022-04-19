package com.shop;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Order {
	static byte id = 1;
	private String orderId;
	private String customerId;
	private String sellerId;
	private String orderDate;
	private byte orderStatus;
	private byte cancellingOrderStatus;//1-cancel request given by customer ,2-accept by seller, 3-deny by seller
	List<Cart> orderdItems = new ArrayList<>();

	public void addOrder(Cart cart) {
		this.customerId = cart.getCustomerId();
		this.sellerId = cart.getSellerId();
		orderdItems.add(cart);
		this.orderDate = this.getDate();
		this.orderId = "BSORDER" + id++;

	}

	public String getDate() {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getDate());
		return String.valueOf(timestamp);
	}
    //on progress
	public void printOrder(Cart cart) {
		System.out.println("\n*******************************Order Details**************************");
		System.out.println("\nOrder Id: "+this.orderId);
		System.out.println("\nCustomer Id: "+this.customerId);
		
	}
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<Cart> getOrderdItems() {
		return orderdItems;
	}

	public void setOrderdItems(List<Cart> orderdItems) {
		this.orderdItems = orderdItems;
	}
    
	public byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(byte orderStatus) {
		this.orderStatus = orderStatus;
	}
    
	public byte getCancellingOrderStatus() {
		return cancellingOrderStatus;
	}

	public void setCancellingOrderStatus(byte cancellingOrderStatus) {
		this.cancellingOrderStatus = cancellingOrderStatus;
	}

	@Override
	public String toString() {
		return "\n***********Order Details***********" + "\nOrder Id : "+orderId + "\nCustomer Id : " + customerId + "\nSeller Id : " + sellerId + "\nOrdered date : "
				+ orderDate + "\norderd Items : " + orderdItems.toString() +"\nOrder status(0-not yet viewed by seller,1 - accept, 2 - deny) : "+orderStatus;
	}
	

}

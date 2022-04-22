package com.footwearShop;

import java.util.List;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
//It manages order related operations.
public class Order {
	static byte id = 1;
	private String orderId;//It stores order Id.
	private String customerId;//It stores customer ID.
	private String sellerId;//It stores seller ID.
	private String orderDate;//It stores order date.
	private byte orderStatus;//It stores order status.
	private byte cancellingOrderStatus;//1-cancel request given by customer ,2-accept by seller, 3-deny by seller.
	List<Cart> orderdItems = new ArrayList<>();//It stores cart object which was ordered by customer.
    //It is used to assign customer Id, seller Id, order Id from cart which is provided by customer.
	public void addOrder(Cart cart) {
		this.customerId = cart.getCustomerId();
		this.sellerId = cart.getSellerId();
		orderdItems.add(cart);
		this.orderDate = this.getDate();
		this.orderId = "BSORDER" + id++;

	}
    //It is used to get the current date with time in form of string.
	public String getDate() {
		Timestamp timestamp = new Timestamp(Calendar.getInstance().get(Calendar.DATE));
		return String.valueOf(timestamp);
	}
    //It is used to print the orders.
	public void printOrder(Cart cart) {
		System.out.println("\n*******************************Order Details**************************");
		System.out.println("\nOrder Id: "+this.orderId);
		System.out.println("\nCustomer Id: "+this.customerId);
		//On progress
		
	}
	//It is  used to get the order Id.
	public String getOrderId() {
		return orderId;
	}
	//It is used to set the order Id.
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
    //It is used to get the customer Id.
	public String getCustomerId() {
		return customerId;
	}
    //It is used to set the customer Id.
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
    //It is used to get the seller Id.
	public String getSellerId() {
		return sellerId;
	}
    //It is used to set the seller Id
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
    //It is used to get the order date.
	public String getOrderDate() {
		return orderDate;
	}
    //It is used to set the order date.
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
    //It is used to get the ordered Items.
	public List<Cart> getOrderdItems() {
		return orderdItems;
	}
    //It is used to get the order status.
	public byte getOrderStatus() {
		return orderStatus;
	}
    //It is used to the order status.
	public void setOrderStatus(byte orderStatus) {
		this.orderStatus = orderStatus;
	}
    //It is used to get the cancelling order status.
	public byte getCancellingOrderStatus() {
		return cancellingOrderStatus;
	}
    //It is used to set the cancelling order status.
	public void setCancellingOrderStatus(byte cancellingOrderStatus) {
		this.cancellingOrderStatus = cancellingOrderStatus;
	}
    //It is used to print order details whenever we print order object.
	@Override
	public String toString() {
		return "\n***********Order Details***********" + "\nOrder Id : "+orderId + "\nCustomer Id : " + customerId + "\nSeller Id : " + sellerId + "\nOrdered date : "
				+ orderDate + "\norderd Items : " + orderdItems.toString() +"\nOrder status(0-not yet viewed by seller,1 - accept, 2 - deny) : "+orderStatus;
	}
	

}

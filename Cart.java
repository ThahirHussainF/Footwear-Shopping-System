package com.shop;

//store the product details for buying
public class Cart {
	private static byte id = 1;
	private String cartId;//It stores cart Id
	private String shopId;//It stores shop Id
	private String customerId;//It stores customer shop Id
	private String sellerId;//It stores seller Id
	private String productId;//It stores product Id
	private int footwearSize;//It stores foot wear size
	private int noOfFootwear;//It stores no of foot wear needed
	private double amount = 0.0;// It stores total purchased amount.
    //It has invoked whenever new cart was created.
	public Cart(String shopId, String productId, int footwearSize, int noOfFootwear,String customerId) {
		this.shopId = shopId;
		this.productId = productId;
		this.footwearSize = footwearSize;
		this.noOfFootwear = noOfFootwear;
		this.customerId=customerId;
		for(Seller seller:Storage.sellersList) {
			if(seller.getMyShop().getShopId().equals(shopId)) {
				this.sellerId=seller.getSellerID();
				break;
			}
		}
		cartId = this.shopId + this.productId + id++;
	}
    //It is used to get cart ID.
	public String getCartId() {
		return cartId;
	}
	//It is used to set cart ID.
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	//It is used to get shop ID.
	public String getShopId() {
		return shopId;
	}
	//It is used to set shop ID.
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	//It is used to get product ID.
	public String getProductId() {
		return productId;
	}
	//It is used to set product ID.
	public void setProductId(String productId) {
		this.productId = productId;
	}
    //It is used get foot wear size.
	public int getFootwearSize() {
		return footwearSize;
	}
	 //It is used set foot wear size.
	public void setFootwearSize(int footwearSize) {
		this.footwearSize = footwearSize;
	}
	 //It is used get number of foot wear needed.
	public int getNoOfFootwear() {
		return noOfFootwear;
	}
	 //It is used set number of foot wear needed.
	public void setNoOfFootwear(int noOfFootwear) {
		this.noOfFootwear = noOfFootwear;
	}
	 //It is used get total amount purchased.
	public double getAmount() {
		return amount;
	}
	 //It is used set total amount purchased.
	public void setAmount(double amount) {
		this.amount = amount;
	}
	//It is used get customer Id.
	public String getCustomerId() {
		return customerId;
	}
	//It is used set customer Id.
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	//It is used get seller Id.
	public String getSellerId() {
		return sellerId;
	}
	//It is used set seller Id.
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	// It was used to print cart details whenever we print cart object has printed.
	@Override
	public String toString() {
		return "\nCart Id = "+cartId+"\nShop Id =" + shopId +"\nProduct Id =" + productId + "\nFootwear size =" + footwearSize
				+ "\nnoOfFootwear = " + noOfFootwear +"\nAmount per product = "+String.format("%.2f",(amount/noOfFootwear))+"\nTotal amount Calculated =" +String.format("%.2f",amount);
	}

}
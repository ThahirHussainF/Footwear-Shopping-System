package com.shop;

//store the product details for buying
public class Cart {
	private static byte id = 1;
	private String cartId;
	private String shopId;
	private String customerId;
	private String sellerId;
	private String productId;
	private int footwearSize;
	private int noOfFootwear;
	private double amount = 0.0;

	public Cart(String shopId, String productId, int footwearSize, int noOfFootwear,String customerId) {
		this.shopId = shopId;
		this.productId = productId;
		this.footwearSize = footwearSize;
		this.noOfFootwear = noOfFootwear;
		this.customerId=customerId;
		for(Seller seller:Storage.sellers) {
			if(seller.getMyShop().getShopId().equals(shopId)) {
				this.sellerId=seller.getSellerID();
				break;
			}
		}
		cartId = this.shopId + this.productId + id++;
	}
    
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getFootwearSize() {
		return footwearSize;
	}

	public void setFootwearSize(int footwearSize) {
		this.footwearSize = footwearSize;
	}

	public int getNoOfFootwear() {
		return noOfFootwear;
	}

	public void setNoOfFootwear(int noOfFootwear) {
		this.noOfFootwear = noOfFootwear;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	@Override
	public String toString() {
		return "\nCart Id = "+cartId+"\nShop Id =" + shopId +"\nProduct Id =" + productId + "\nFootwear size =" + footwearSize
				+ "\nnoOfFootwear = " + noOfFootwear +"\nAmount per product = "+String.format("%.2f",(amount/noOfFootwear))+"\nTotal amount Calculated =" +String.format("%.2f",amount);
	}

}
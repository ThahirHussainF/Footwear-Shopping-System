package com.shop;
import com.shop.Seller;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;
public class Shop {
	private static int id = 1;
	private  String shopId;
	private  String shopName;
	private  String ownerName;
	private  Seller seller;
	private  int shopStatus=0;//0 means not yet approval by admin, 1 means approval by admin, 2 mean denied by admin
	Map<Category, List<Product>> categoryMap = new HashMap<>();

	public Shop() {
		for (Category value : Category.values()) {
			categoryMap.put(value, new ArrayList<Product>());
		}
		Date date=new Date();
		this.shopId="BS"+(date.getYear()+1900)+"SHOP"+id++;
	}

	public void addProduct(Category c, Product p) {
		switch (c) {
		case MALE:
			categoryMap.get(c).add(p);
			break;
		case FEMALE:
			categoryMap.get(c).add(p);
			break;
		case CHILDMALE:
			categoryMap.get(c).add(p);
			break;
		case CHILDFEMALE:
			categoryMap.get(c).add(p);
			break;
		case BABY:
			categoryMap.get(c).add(p);
			break;
		}
	}

	public void removeProduct(Category c, int productId) {
		for (Entry<Category, List<Product>> catMap : categoryMap.entrySet()) {
			if (catMap.getKey().equals(c)) {
				for (int i = 0; i < catMap.getValue().size(); i++) {
					if (catMap.getValue().get(i).getProductId() == productId) {
						catMap.getValue().remove(i);
						break;
					}
					break;
				}
			}
		}
	}

	public void updateProduct(Category c, int productId) {
		for (Map.Entry<Category, List<Product>> catMap : categoryMap.entrySet()) {
			if (catMap.getKey().equals(c)) {
				for (int i = 0; i < catMap.getValue().size(); i++) {
					if (catMap.getValue().get(i).getProductId() == productId) {
						boolean exit = true;
						do {
							System.out.println("which do you want to update?");
							System.out.println(
									"\1.Product Name\n2.Product Price\n3.Update the count for each size\4.Exit");
							int choice;
							System.out.println("Enter your choice: ");
							Scanner ob = new Scanner(System.in);
							choice = ob.nextInt();
							switch (choice) {
							case 1:
								String productName;
								System.out.println("Enter the Product Name:");
								productName = ob.nextLine();
								catMap.getValue().get(i).setProductName(productName);
								break;
							case 2:
								double productPrice;
								System.out.println("Enter the Product Price: ");
								productPrice = ob.nextDouble();
								catMap.getValue().get(i).setPrice(productPrice);
								break;
							case 3:
								int noOfProductsAvailable;
								int size;
								System.out.println("Enter the size and number of Products: ");
								size = ob.nextInt();
								noOfProductsAvailable = ob.nextInt();
								catMap.getValue().get(i).eachSizeWithTheirCount.put(size, noOfProductsAvailable);
								break;
							case 4:
								exit = false;
								break;

							}
						} while (exit);

					}
				}
			}
		}
	}

	public void printProducts() {
        //print
	}
  
	
    public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public int getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(int shopStatus) {
		this.shopStatus = shopStatus;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String toString() {
    	return "\nShop ID: "+this.shopId+"\nShop Name: "+this.shopName+"\nSeller Name: "+this.ownerName+"\nSeller ID: "+
               this.seller.getSellerID()+"\nShop Status: "+this.shopStatus+"(0->Not yet approved, 1-> Approved, 2->Denied)"+
    			"\nSeller Details"+this.seller.toString();
    }
	
}

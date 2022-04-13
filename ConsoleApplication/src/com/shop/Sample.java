package com.shop;
import java.util.ArrayList;
//enum day {
//	MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
//	day() {
//	   System.out.println("Hi, I am enumerator");
//	}
//	public void print() {
//		System.out.println(this.toString());
//	}
//}

//for(Map.Entry<Seller,Shop> shops:Admin.shops.entrySet()) {
//	if(shops.getValue().getShopId()==shopId) {
//		int status=shops.getValue().getShopStatus();
//		if(status==0) {
//			System.out.println("Your shop not yet approved.please waiting some time!");
//			return;
//		}
//		else if(status==1) {
//			System.out.println("congratulation!.Your shop was approved.");
//			return;
//		}
//		else if(status==0) {
//			System.out.println("Sorry!.Your shop was denied.please check terms and conditions");
//			return;
//		}
//	}
//}

class Laptop {
	int id;
	String n;
}
public class Sample {
	public static void main(String[] args) {
//	 day d=day.FRIDAY;
//	 System.out.println(d);
//	 d.print();
		
		ArrayList<Laptop> list=new ArrayList<>();
		for(int i=0; i<100; i++) {
			Laptop l=new Laptop();
			list.add(l);
		}
		
	}

}

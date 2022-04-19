package com.shop;
class Sample {
	public static void main(String[] args) {
		int a=10;
		int b=0;
		try {
			System.out.println(a/b);
		}
		catch(ArithmeticException e) {
			System.out.println(e);
			
		}
		finally {
			System.out.println("Hi,welcome to aspire systems!");
		}
		for(int i=0; i<5; i++) {
			System.out.println(i);
		}
	}
}
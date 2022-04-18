package com.shop;
class A {
	A(){
		System.out.println("Default constructor");
	}
	A(int i) {
		System.out.println("Parameterized constructorS");
	}
	public static void main(String[] args) {
		A a=new A();
	}
}
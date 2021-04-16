package com.springcore.constructinject;

public class Demo3 {
	private String name;
	private int age;
	private int id;
	private String address;
	public Demo3(String name, int age, int id, String address) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.address = address;
	}
	public void display() {
		System.out.println("Name : "+this.name);
		System.out.println("age : "+this.age);
		System.out.println("id : "+this.id);
		System.out.println("Address: "+this.address);
		
	}
	
	

}

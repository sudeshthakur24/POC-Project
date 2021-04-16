package com.springcore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
	
		ApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/collections/config1.xml");
		Demo2 program1=(Demo2) context.getBean("program1");
		System.out.println(program1.getName());
		System.out.println(program1.getPhone());
		System.out.println(program1.getAddress());
		System.out.println(program1.getCourses());
	}

}
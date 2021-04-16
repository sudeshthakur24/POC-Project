package com.springcore.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/ref/config2.xml");
		A aref=(A) context.getBean("aref");
		System.out.println(aref.getX());
		System.out.println(aref.getOb().getY());
		

	}

}

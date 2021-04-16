package com.springcore.constructinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/constructinject/config3.xml");
		Demo3 temp=(Demo3) context.getBean("program");
		temp.display();

	}

}

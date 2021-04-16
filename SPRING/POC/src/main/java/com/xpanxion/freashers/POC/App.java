package com.xpanxion.freashers.POC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
       Demo program1=(Demo) context.getBean("program1");
       Demo program2=(Demo) context.getBean("program2");
       Demo program3=(Demo) context.getBean("program3");
     
       System.out.println(program1);
       System.out.println(program2);
       System.out.println(program3);
    }
}

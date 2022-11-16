package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Demo d = ctx.getBean("demo",Demo.class);
		
		d.showDetails();
		
		ClassPathXmlApplicationContext ctx2 = (ClassPathXmlApplicationContext) ctx;
		
		ctx2.close();
		
	}

}

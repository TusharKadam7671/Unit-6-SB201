package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Collage c = ctx.getBean("c1",Collage.class);
		
		System.out.println(c.getCollage_name());
		System.out.println(c.getCollage_address());
		System.out.println(c.getStudent());

	}

}

package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Drawshapes obj = ctx.getBean("drawshapes",Drawshapes.class);
		
		obj.drawShapes();
		
		//output- You have drawn Triangle
		
		

	}

}

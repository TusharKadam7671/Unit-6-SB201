package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		StudentService sService = ctx.getBean("studentservice",StudentService.class);
		
		
		sService.printMap();
		
		sService.printList();
		
		sService.printAppName();

	}

}

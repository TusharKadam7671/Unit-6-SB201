package com.masai;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

	
	public void start() 
	{
		System.out.println("Car journey started");
	}
	
	
	@Override
	public void go() {

		start();
		
	}

}

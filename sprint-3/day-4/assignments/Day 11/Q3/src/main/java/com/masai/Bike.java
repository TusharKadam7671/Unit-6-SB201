package com.masai;

import org.springframework.stereotype.Component;


@Component
public class Bike implements Vehicle{
	
	public void start()
	{
		System.out.println("Bike journey started");
	}
	
	
	@Override
	public void go()
	{
		start();
	}

}

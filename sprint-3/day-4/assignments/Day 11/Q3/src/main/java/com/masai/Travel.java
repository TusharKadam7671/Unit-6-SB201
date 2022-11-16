package com.masai;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Travel {
	
	void journey()
	{
		v.go();
		System.out.println("Journey continues");
	}
	
	
	@Autowired
	@Qualifier("v")
	private Vehicle v;
	
	
	@PostConstruct
	public void mySetUp()
	{
		System.out.println("Post construct");
		System.out.println("Journey started");
	}
	
	@PreDestroy
	public void destroy()
	{
		System.out.println("Pre destroy");
		System.out.println("Journey ended");
	}

}

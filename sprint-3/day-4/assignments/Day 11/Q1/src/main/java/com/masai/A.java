package com.masai;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A {
	
	
	@Autowired
	List<Student> students;
	
	
	@Autowired
	List<String> cities;
	
	
	
	@PostConstruct
	public void mySetUp()
	{
		System.out.println("Inside mySetup..PostConstruct");
		System.out.println();
		
	}
	
	@PreDestroy
	public void destroy()
	{
		System.out.println();
		System.out.println("Inside destroy..PreDestroy");
		
	}
	
	
	public void funA()
	{
		System.out.println("List of cities-->");
		cities.forEach(c -> System.out.println(c));
		
		System.out.println("-------------------------");
		
		System.out.println("List of students-->");
		students.forEach(s -> System.out.println(s));
		
		
	}

}

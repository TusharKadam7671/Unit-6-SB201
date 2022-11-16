package com.masai;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service(value="studentservice")
public class StudentService {
	
	@Autowired
	@Qualifier("map")
	private Map<Student, Course> theMap; // inject 3 entries with valid details
	
	@Autowired
	@Qualifier("list")
	private List<Student> theList; //inject List of 5 Student object
	
	@Value("${name}")
	private String appName; //inject the AppName from the properties file
	//Hint: Make use of @Bean annotation to inject theMap and theList;
	
	
	public void printMap(){
	//print all the student's and their course details from theMap
		for(Student key : theMap.keySet())
		{
			System.out.println(key+" "+theMap.get(key));
		}
		
	}
	public void printList(){
	//sort the List of Student according to the marks (make use of Lamda
	//expression).
	//print all the sorted Student Details
		
		Collections.sort(theList,(s1,s2)->(s1.getMarks() > s2.getMarks() ? +1 : -1));
		
		theList.forEach(s->
		{
			System.out.println(s);
		});
		
	}
	public void printAppName(){
	//print the injected appName
		
		System.out.println(appName);
		
	}
	

}

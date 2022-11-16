package com.masai;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.masai")
@PropertySource("a1.properties")
public class AppConfig {
	
	@Bean("list")
	public List<Student> getStudentList()
	{
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(1, "name1", "Mumbai", "abc@gmail.com", 456));
		students.add(new Student(2, "name2", "Pune", "tru@gmail.com", 784));
		students.add(new Student(3, "name3", "Chennai", "qas@gmail.com", 245));
		students.add(new Student(4, "name4", "Delhi", "vcb@gmail.com", 645));
		students.add(new Student(5, "name5", "Kolkata", "poi@gmail.com", 506));
		
		return students;
	}
	
	@Bean("map")
	public Map<Student,Course> getMap()
	{
		Map<Student,Course> map = new LinkedHashMap<>();
		
		map.put(new Student(1, "name1", "Mumbai", "abc@gmail.com", 456), new Course(1, "Java", 7, 10000));
		map.put(new Student(2, "name2", "Pune", "tru@gmail.com", 784), new Course(2, "React", 6, 9000) );
		map.put(new Student(3, "name3", "Chennai", "qas@gmail.com", 245), new Course(3, "CSBT", 4, 5000));
		
		
		return map;
	}
	

}

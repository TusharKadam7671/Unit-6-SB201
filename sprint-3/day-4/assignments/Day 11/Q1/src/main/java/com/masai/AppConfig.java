package com.masai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.masai")
public class AppConfig {
	
	
	@Bean("students")
	public List<Student> getStudent()
	{
		
		List<Student> students = new ArrayList<>();
		
		
		Student s1 = new Student(1, "Virat", 100);
		Student s2 = new Student(2, "Suryakumar", 96);
		Student s3 = new Student(3, "Ashwin", 80);
		Student s4 = new Student(4, "Dinesh", 85);
		Student s5 = new Student(5, "Hardik", 91);
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);

		return students;
		
	}
	
	@Bean("cities")
	public List<String> getCities()
	{
		List<String> cities = new ArrayList<>();
		
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Kolkata");
		cities.add("Chennai");
		cities.add("Pune");
		
		return cities;
	}

}

package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Employee;

@Controller
@RestController
public class MyController {
	
	@RequestMapping("/welcome")
	@ResponseBody
	public String myWelcomeService()
	{
		return "Hello World";
	}
	
	
	@RequestMapping("/hello")
	public String myHelloService()
	{
		return "Welcome to Spring Boot";
	}
	
	@RequestMapping("/employee")
	public Employee sendEmp() 
	{
		Employee emp = new Employee(1,"Employee1","HR",75000);
		return emp;
	}
	
	
	@RequestMapping("/employees")
	public List<Employee> getEmployeeList()
	{
		List<Employee> list = new ArrayList<>();
		
		Employee e1 = new Employee(1, "Employee1", "Sales", 50000);
		list.add(e1);
		
		Employee e2 = new Employee(2, "Employee2", "Marketing", 60000);
		list.add(e2);
		
		Employee e3 = new Employee(3, "Employee3", "HR", 80000);
		list.add(e3);
		
		Employee e4 = new Employee(4, "Employee4", "Sales", 70000);
		list.add(e4);
		
		Employee e5 = new Employee(5, "Employee5", "HR", 90000);
		list.add(e5);
		
		
		return list;
	}

}

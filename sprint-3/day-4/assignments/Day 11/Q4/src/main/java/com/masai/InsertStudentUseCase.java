package com.masai;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

@Controller(value="isuc")
public class InsertStudentUseCase {
	
	@Autowired
	private StudentService sService;
	
	public void insertStudent()
	{
		Scanner sc = new Scanner(System.in);
		
		//take the student details from the user
		//compose student obj;
		
		System.out.println("Enter Name");
		String name = sc.next();
		
		System.out.println("Enter Marks");
		int marks = sc.nextInt();
		
	
		
		
		Student student = new Student(); //put all values in new student obj from scanner
		
		student.setName(name);
		student.setMarks(marks);
		
		//call the saveStudent() of StudentService
		
		String result = sService.saveStudent(student);
		
		System.out.println(result);
	}

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
//		ctx.getBean("insertStudentUseCase",InsertStudentUseCase.class);
//		but by changing id to "isuc" see next to @Controller.
		InsertStudentUseCase obj =  ctx.getBean("isuc",InsertStudentUseCase.class);
		
		obj.insertStudent();
		
	}

}

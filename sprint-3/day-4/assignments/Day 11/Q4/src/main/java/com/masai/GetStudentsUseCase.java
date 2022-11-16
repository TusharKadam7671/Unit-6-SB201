package com.masai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

@Controller(value="gsuc")
public class GetStudentsUseCase {
	
	@Autowired
	private StudentService sService;
	
	public void getStudentDetails()
	{
		List<Student> students = sService.getAllStudents();
		
		students.forEach( s-> System.out.println(s));
	}
	
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
//		ctx.getBean("insertStudentUseCase",InsertStudentUseCase.class);
//		but by changing id to "isuc" see next to @Controller.
		
		GetStudentsUseCase obj =  ctx.getBean("gsuc",GetStudentsUseCase.class);
		
		obj.getStudentDetails();
		
	}

}

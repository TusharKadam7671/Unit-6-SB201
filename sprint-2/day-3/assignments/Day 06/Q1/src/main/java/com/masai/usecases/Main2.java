package com.masai.usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.EMUtil.EMUtil;
import com.masai.model.Collage;
import com.masai.model.Student;

public class Main2 {

	public static void main(String[] args) {

		EntityManager em = EMUtil.provideEntityManager();
		
		/*
		Collage c1 = em.find(Collage.class, 5);
		
		List<Student> students = c1.getStudents();
		
		students.forEach(s ->{
			
			System.out.println("Roll no.: "+s.getStudentRoll());
			System.out.println("Name: "+s.getStudentName());
			System.out.println("Mobile no.: "+s.getMobileNumber());
			System.out.println("Email: "+s.getEmail());
			
			System.out.println("*********************");
			
		});
		*/
		
		//using jpql----->
		
		String jpql = "from Student where clg_collageId=5";
		Query q = em.createQuery(jpql);
		List<Student> list = q.getResultList();
		
		list.forEach(s ->{
			
			System.out.println("Roll no.: "+s.getStudentRoll());
			System.out.println("Name: "+s.getStudentName());
			System.out.println("Mobile no.: "+s.getMobileNumber());
			System.out.println("Email: "+s.getEmail());
			
			System.out.println("*********************");
			
		});

	}

}

package com.masai.usecases;

import javax.persistence.EntityManager;


import com.masai.EMUtil.EMUtil;
import com.masai.model.Course;
import com.masai.model.Student;


public class Main {
	
	public static void main(String[] args) {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Course c1 = new Course();
		c1.setCourseName("Java");
		c1.setDuration("9 months");
		c1.setFee(900000);
		
		Course c2 = new Course();
		c2.setCourseName("MERN");
		c2.setDuration("8 months");
		c2.setFee(750000);
		
		//creating student without course
		Student s1 = new Student();
		s1.setName("Suraj");
		s1.setEmail("suraj@gmail.com");
		s1.setMobile("7218459624");
		
		Student s2 = new Student();
		s2.setName("Mini");
		s2.setEmail("Mini@gmail.com");
		s2.setMobile("8954785204");
		
		//associating course Java with both s1 and s2
		c1.getStudentList().add(s1);
		c1.getStudentList().add(s2);
		
		//student 2 wants second course also
		s2.getCourseList().add(c2);
		c2.getStudentList().add(s2);
		
		
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.getTransaction().commit();
		
		
		
		em.close();
		
		System.out.println("Done");
		
	}
	
	

}

package com.masai.usecases;

import javax.persistence.EntityManager;

import com.masai.EMUtil.EMUtil;
import com.masai.model.Collage;
import com.masai.model.Student;

public class Main1 {

	public static void main(String[] args) {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Collage c1 = new Collage();
		c1.setCollageName("Abc collage");
		c1.setCollageAddress("Pune");
		
		Student s1 = new Student();
		s1.setStudentName("student1");
		s1.setMobileNumber("7219497671");
		s1.setEmail("s1@gmail.com");
		s1.setClg(c1);
		
		Student s2 = new Student();
		s2.setStudentName("student2");
		s2.setMobileNumber("7821457836");
		s2.setEmail("s2@gmail.com");
		s2.setClg(c1);
		
		Student s3 = new Student();
		s3.setStudentName("student3");
		s3.setMobileNumber("6587459127");
		s3.setEmail("s3@gmail.com");
		s3.setClg(c1);
		
		Student s4 = new Student();
		s4.setStudentName("student4");
		s4.setMobileNumber("8945253614");
		s4.setEmail("s4@gmail.com");
		s4.setClg(c1);
		
		c1.getStudents().add(s1);
		c1.getStudents().add(s2);
		c1.getStudents().add(s3);
		c1.getStudents().add(s4);
		
		//------------------------------------------//
		
		Collage c2 = new Collage();
		c2.setCollageName("Def collage");
		c2.setCollageAddress("Mumbai");
		
		Student s5 = new Student();
		s5.setStudentName("student5");
		s5.setMobileNumber("7671023654");
		s5.setEmail("s5@gmail.com");
		s5.setClg(c2);
		
		Student s6 = new Student();
		s6.setStudentName("student6");
		s6.setMobileNumber("7210365974");
		s6.setEmail("s6@gmail.com");
		s6.setClg(c2);
		
		Student s7 = new Student();
		s7.setStudentName("student3");
		s7.setMobileNumber("8745459127");
		s7.setEmail("s7@gmail.com");
		s7.setClg(c2);
		
		Student s8 = new Student();
		s8.setStudentName("student4");
		s8.setMobileNumber("8903154798");
		s8.setEmail("s8@gmail.com");
		s8.setClg(c2);
		
		c2.getStudents().add(s5);
		c2.getStudents().add(s6);
		c2.getStudents().add(s7);
		c2.getStudents().add(s8);
		
		//----------------------------//
		
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(c2);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Done");
		
		

	}

}

/*
mysql> select * from collage;
+-----------+----------------+-------------+
| collageId | collageAddress | collageName |
+-----------+----------------+-------------+
|         5 | Pune           | Abc collage |
|        10 | Mumbai         | Def collage |
+-----------+----------------+-------------+

mysql> select * from student;
+-------------+--------------+--------------+-------------+---------------+
| studentRoll | email        | mobileNumber | studentName | clg_collageId |
+-------------+--------------+--------------+-------------+---------------+
|           6 | s1@gmail.com | 7219497671   | student1    |             5 |
|           7 | s2@gmail.com | 7821457836   | student2    |             5 |
|           8 | s3@gmail.com | 6587459127   | student3    |             5 |
|           9 | s4@gmail.com | 8945253614   | student4    |             5 |
|          11 | s5@gmail.com | 7671023654   | student5    |            10 |
|          12 | s6@gmail.com | 7210365974   | student6    |            10 |
|          13 | s7@gmail.com | 8745459127   | student3    |            10 |
|          14 | s8@gmail.com | 8903154798   | student4    |            10 |
+-------------+--------------+--------------+-------------+---------------+

*/


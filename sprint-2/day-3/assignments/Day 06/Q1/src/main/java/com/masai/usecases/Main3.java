package com.masai.usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.EMUtil.EMUtil;
import com.masai.model.Collage;
import com.masai.model.Student;

public class Main3 {

	public static void main(String[] args) {

		EntityManager em = EMUtil.provideEntityManager();
		
		
		/*
		Student s = em.find(Student.class, 11);
		
		Collage c = s.getClg();
		
		System.out.println(c);
		*/
		
		
		//using jpql----->
		
		
		String jpql = "select c.collageId,c.collageName from Collage c inner join Student s on c.collageId=s.clg where s.studentRoll=11";
		
		Query q = em.createQuery(jpql);
		
		List<Object[]> list = q.getResultList();
		
		for(Object[] or : list)
		{
			int id = (int) or[0];
			String name = (String) or[1];
			
			System.out.println(id+" "+name);
			
		}
		
		//-----------------------------------//
		
		Object obj = q.getSingleResult();
		
		Object[] clg = (Object[]) obj;
		
		int id = (int) clg[0];
		String name = (String) clg[1];
		
		System.out.println(id+" "+name);
		
		
		
		

	}

}

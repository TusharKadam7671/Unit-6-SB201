package com.masai.usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.EMUtil.EMUtil;
import com.masai.model.SalariedEmployee;

public class Demo1 {
	
	public static void main(String[] args) {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		String jpql = "from SalariedEmployee";
		
		Query q = em.createQuery(jpql);
		
		List<SalariedEmployee> list = q.getResultList();
		
		list.forEach(e ->
		{
			System.out.println(e.getEmpId());
			System.out.println(e.getEmpName());
			System.out.println(e.getSalary());
			System.out.println(e.getEmail());
		});
		
	}

}

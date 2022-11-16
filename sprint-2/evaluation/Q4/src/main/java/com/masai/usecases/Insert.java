package com.masai.usecases;

import javax.persistence.EntityManager;

import com.masai.EMUtil.EMUtil;
import com.masai.model.ContractualEmployee;
import com.masai.model.SalariedEmployee;

public class Insert {
	
	public static void main(String[] args) {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		SalariedEmployee s1 = new SalariedEmployee();
		s1.setEmpName("S1");
		s1.setSalary(20000);
		s1.setEmail("s1@gmail.com");
		
		SalariedEmployee s2 = new SalariedEmployee();
		s2.setEmpName("S2");
		s2.setSalary(30000);
		s2.setEmail("s2@gmail.com");
		
		SalariedEmployee s3 = new SalariedEmployee();
		s3.setEmpName("S3");
		s3.setSalary(40000);
		s3.setEmail("s3@gmail.com");
		
		SalariedEmployee s4 = new SalariedEmployee();
		s4.setEmpName("S4");
		s4.setSalary(60000);
		s4.setEmail("s4@gmail.com");
		
		ContractualEmployee c1 = new ContractualEmployee();
		c1.setEmpName("c1");
		c1.setNoOfWorkingDays(2);
		c1.setCostofperday(200);
		c1.setMobileNumber("7845123698");
		
		ContractualEmployee c2 = new ContractualEmployee();
		c2.setEmpName("c2");
		c2.setNoOfWorkingDays(3);
		c2.setCostofperday(300);
		c2.setMobileNumber("8845123698");
		
		ContractualEmployee c3 = new ContractualEmployee();
		c3.setEmpName("c3");
		c3.setNoOfWorkingDays(3);
		c3.setCostofperday(400);
		c3.setMobileNumber("9845123698");
		
		ContractualEmployee c4 = new ContractualEmployee();
		c4.setEmpName("c4");
		c4.setNoOfWorkingDays(4);
		c4.setCostofperday(700);
		c4.setMobileNumber("5845123698");
		
		em.getTransaction().begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.getTransaction().commit();
		em.close();
		System.out.println("Done");
		
	}

}

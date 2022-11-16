package com.masai.usecases;

import javax.persistence.EntityManager;


import com.masai.EMUtil.EMUtil;
import com.masai.model.Address;
import com.masai.model.Customer;


public class Save {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Customer cus1 = new Customer();
		
		cus1.setName("Ramesh");
		cus1.setMobileNumber("9881765585");
		cus1.setEmail("ramesh@gamil.com");
		cus1.getAddresses().add(new Address("Mh", "Pune", "787887","homeAddress"));
		cus1.getAddresses().add(new Address("MP", "Indore", "584542","officeAddress"));
		
		
	      Customer cus2 = new Customer();
	        
	        cus2.setName("Tushar");
	        cus2.setMobileNumber("7219497671");
	        cus2.setEmail("tush@gamil.com");
	        cus2.getAddresses().add(new Address("MH", "Mumbai", "404045","homeAddress"));
	        cus2.getAddresses().add(new Address("MP", "Bhopal", "989547","officeAddress"));
	     

		
		em.getTransaction().begin();
		
		em.persist(cus1);
		em.persist(cus2);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Done");

	}

}


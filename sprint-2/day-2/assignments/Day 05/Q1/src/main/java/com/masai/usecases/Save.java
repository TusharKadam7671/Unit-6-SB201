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
		cus1.getAddresses().add(new Address("Mh", "Pune", "787887","address1"));
		cus1.getAddresses().add(new Address("MP", "Indore", "584542","address2"));
		cus1.getAddresses().add(new Address("KA", "Bangalore", "214584","address3"));
		
	      Customer cus2 = new Customer();
	        
	        cus2.setName("Tushar");
	        cus2.setMobileNumber("7219497671");
	        cus2.setEmail("tush@gamil.com");
	        cus2.getAddresses().add(new Address("MH", "Mumbai", "404045","address1"));
	        cus2.getAddresses().add(new Address("MP", "Bhopal", "989547","address2"));
	        cus2.getAddresses().add(new Address("TL", "Hyderabad", "656987","address3"));

		
		em.getTransaction().begin();
		
		em.persist(cus1);
		em.persist(cus2);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Done");

	}

}

/*
from mySQL-
mysql> show tables;
+--------------------+
| Tables_in_db1      |
+--------------------+
| emp                |
| emp_adr            |
| hibernate_sequence |
+--------------------+
mysql> select * from emp;
+-----+------------------+--------------+--------+
| cid | email            | mobileNumber | name   |
+-----+------------------+--------------+--------+
|   1 | ramesh@gamil.com | 9881765585   | Ramesh |
+-----+------------------+--------------+--------+
mysql> select * from emp_adr;
+--------+-----------+---------+-------+----------+
| emp_id | city      | pincode | state | type     |
+--------+-----------+---------+-------+----------+
|      1 | Pune      | 787887  | Mh    | address1 |
|      1 | Indore    | 584542  | MP    | address2 |
|      1 | Bangalore | 214584  | KA    | address3 |
+--------+-----------+---------+-------+----------+
*/
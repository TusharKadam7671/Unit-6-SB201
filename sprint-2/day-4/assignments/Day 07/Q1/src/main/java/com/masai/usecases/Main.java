package com.masai.usecases;

import javax.persistence.EntityManager;

import com.masai.EMUtil.EMUtil;
import com.masai.model.Address;
import com.masai.model.Employee;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee emp1 = new Employee();
		emp1.setName("Rahul");
		emp1.setSalary(1548956);
		Address a1 = new Address("MH","Pune","415409");
		emp1.setHomeAddress(a1);
		Address a2 = new Address("MH", "Mumbai", "401403");
		emp1.setOfficeAddress(a2);
		
		Employee emp2 = new Employee();
		emp2.setName("Suraj");
		emp2.setSalary(895600);
		Address a3 = new Address("MP","Bhopal","785409");
		emp2.setHomeAddress(a3);
		Address a4 = new Address("GA", "Panaji", "801403");
		emp2.setOfficeAddress(a4);

		Employee emp3 = new Employee();
		emp3.setName("Kiran");
		emp3.setSalary(56000);
		Address a5 = new Address("MH","Pune","415409");
		emp3.setHomeAddress(a5);
		Address a6 = new Address("MH", "Mumbai", "401403");
		emp3.setOfficeAddress(a6);
		
		Employee emp4 = new Employee();
		emp4.setName("Prabhas");
		emp4.setSalary(9548956);
		Address a7 = new Address("MH","Pune","415409");
		emp4.setHomeAddress(a7);
		Address a8 = new Address("MH", "Mumbai", "401403");
		emp4.setOfficeAddress(a8);
		
		em.getTransaction().begin();
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.persist(emp4);
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Done");
		
	}
	
	

}

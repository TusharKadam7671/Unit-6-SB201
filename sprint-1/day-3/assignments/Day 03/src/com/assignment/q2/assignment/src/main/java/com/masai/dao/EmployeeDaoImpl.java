package com.masai.dao;

import javax.persistence.EntityManager;

import com.masai.entities.Employee;
import com.masai.utility.Connection;

public class EmployeeDaoImpl implements EmployeeDao{

	public void save(Employee emp) {
		// TODO Auto-generated method stub
		
		EntityManager em = Connection.getConnection().createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(emp);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Employee added successfully");
	}

	public String getAddressOfEmployee(int empId) {
		// TODO Auto-generated method stub

		EntityManager em = Connection.getConnection().createEntityManager();
		
		Employee emp = em.find(Employee.class, empId);
		
		if(emp == null)
		{
			return "Employee not exists";
		}
		else
		{
			return emp.getAddress();
		}
	}

	public String giveBonusToEmployee(int empId, int bonus) {
		// TODO Auto-generated method stub

		EntityManager em = Connection.getConnection().createEntityManager();
		
		Employee emp = em.find(Employee.class, empId);
		
		if(emp != null)
		{
			
			em.getTransaction().begin();
			
			emp.setSalary(emp.getSalary()+bonus);
			
			em.getTransaction().commit();
			
			em.close();
			
			return "Bonus is added";
			
		}
		else
		{
			em.close();
			
			return "Employee not exists";
		}
	}

	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub

		EntityManager em = Connection.getConnection().createEntityManager();
		
		Employee emp = em.find(Employee.class, empId);
		
		if(emp != null)
		{
			em.getTransaction().begin();
			
			em.remove(emp);
			
			em.getTransaction().commit();
			
			em.close();
			
			return true;
			
		}
		else
		{
			em.close();
			
			return false;
			
		}
		
	}

}

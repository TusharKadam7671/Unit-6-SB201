package com.masai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.EMUtil.EMUtil;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.model.Department;
import com.masai.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public void addDepartment(Department dept) {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		em.persist(dept);
		em.getTransaction().commit();
		
		em.close();
		System.out.println("done");
		
	}

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		
		em.close();
		System.out.println("done");
		
	}

	@Override
	public void registerEmployeeTODepartment(int empId, int deptId) throws EmployeeException, DepartmentException {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee emp = em.find(Employee.class, empId);
		
		Department dept = em.find(Department.class, deptId);
		
		if(emp != null && dept != null)
		{
			emp.setDept(dept);
			dept.getEmp().add(emp);
			
			em.getTransaction().begin();
			em.persist(emp);
			em.getTransaction().commit();
			em.close();
			System.out.println("Registered");
		}
		
		else if(emp==null)
		{
			throw new EmployeeException("Employee not found");
		}
		
		else if(dept==null)
		{
			throw new DepartmentException("Department not found");
		}
		
	}

	@Override
	public List<Employee> getAllEmployeeWithDeptName(String deptName) throws EmployeeException {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		
		String jpql = "select emp from Department where deptName=:nm";
		Query q = em.createQuery(jpql);
		q.setParameter("nm", deptName);
		
		List<Employee> list = q.getResultList();
		
		if(list.size()==0)
		{
			throw new EmployeeException("List is empty");
		}
		
		return list;
	}

	@Override
	public Department getDepartmentDetailsByEmployeeId(int empId) throws DepartmentException {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee emp = em.find(Employee.class, empId);
		
		Department dept = emp.getDept();
		
		if(dept == null)
		{
			throw new DepartmentException("Department not found");
		}
		
		return dept;
	}

}

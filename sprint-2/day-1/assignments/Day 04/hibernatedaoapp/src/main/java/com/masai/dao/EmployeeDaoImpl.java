package com.masai.dao;

import javax.persistence.EntityManager;

import com.masai.EMUtil.EMUtil;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public Employee registerEmployee(Employee employee) throws EmployeeException {

        EntityManager em = EMUtil.provideEntityManager();
        
        try
        {
            
        em.getTransaction().begin();
        
        em.persist(employee);
        
        em.getTransaction().commit();
        
        Employee employee2 = em.find(Employee.class, employee.getEmpId());
        
        em.close();
        
        return employee2;
         
        }
        
        catch (Exception e) {
            // TODO: handle exception
            throw new EmployeeException("Employee not registered");
        }
        
        
    }

    @Override
    public Employee getEmployeeById(int empId) throws EmployeeException {

        Employee employee = null;
        
        EntityManager em = EMUtil.provideEntityManager();
        
        try {
            
           
            employee = em.find(Employee.class, empId);
            
            em.close();
            

            if(employee != null)
            {
                return employee;
            }else
            {
                throw new EmployeeException("Employee not found");
            }
            
            
        } catch (Exception e) {
            throw new EmployeeException("Employee not found");
        }
        
        
        
    }

    @Override
    public Employee deleteEmployeeById(int empId) throws EmployeeException {
            
        Employee employee = null;
        
        EntityManager em = EMUtil.provideEntityManager();
        
        try {
            
           
            employee = em.find(Employee.class, empId);
            

            if(employee != null)
            {
                em.getTransaction().begin();
                
                em.remove(employee);
                
                em.getTransaction().commit();
                
                em.close();
                
                return employee;

            }else
            {
                throw new EmployeeException("Employee not found");
            }
            
            
        } catch (Exception e) {
            throw new EmployeeException("Employee not found");
        }
        
        
    }

    @Override
    public Employee updateEmployee(Employee employee) throws EmployeeException {


        EntityManager em = EMUtil.provideEntityManager();
        
        try {
            
            em.getTransaction().begin();
            
            em.merge(employee);
            
            em.getTransaction().commit();
            
            em.close();
            
            return employee;
            
            
        } catch (Exception e) {
            // TODO: handle exception
            throw new EmployeeException("Employee not updated");
        }
        
       
    }
    

}

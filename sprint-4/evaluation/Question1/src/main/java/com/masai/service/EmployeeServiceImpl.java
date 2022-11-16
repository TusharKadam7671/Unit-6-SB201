package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;
import com.masai.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		
		return dao.save(emp);
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		if(dao.findById(empId).isPresent())
		{
			return dao.findById(empId).get();
		}
		else
		{
			throw new EmployeeException("Employee not found");
		}
	
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee> list = dao.findAll();
		
		if(list.size() > 0)
		{
			return list;
		}
		else
		{
			throw new EmployeeException("Employee list is empty");
		}
	}

	@Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		if(dao.findById(empId).isPresent())
		{
			Employee emp = dao.findById(empId).get();
			dao.delete(emp);
			return emp;
		}
		else
		{
			throw new EmployeeException("Employee is not found");
		}
		
	}

	
	@Override
	public Employee loginEmployee(String email, String password) throws EmployeeException {
		// TODO Auto-generated method stub
		/*
		Employee emp = dao.loginEmployee(email, password);
		if(emp==null)
		{
			throw new EmployeeException("Employee not available");
		}
		else
		{
			return emp;
		}
		*/
		return null;
	}

	@Override
	public List<Employee> getEmployeeDetailsByAddress(String address) throws EmployeeException {
		// TODO Auto-generated method stub
		
		List<Employee> list2 = dao.findByAddress(address);
		if(list2.size() > 0)
		{
			return list2;
		}
		else
		{
			throw new EmployeeException("Employee with given address is not available");
		}
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		if(dao.findById(emp.getEmpId()).isPresent())
		{
			Employee emp2 = dao.findById(emp.getEmpId()).get();
			
			emp2.setEmpName(emp.getEmpName());
			emp2.setSalary(emp.getSalary());
			emp2.setAddress(emp.getAddress());
			emp2.setEmail(emp.getEmail());
			emp2.setMobile(emp.getMobile());
			emp2.setPassword(emp.getPassword());
			
			dao.save(emp2);
			
			return emp2;
		}
		else
		{
			throw new EmployeeException("Employee not found");
		}
	}

	
	@Override
	public String[] getNameAndAddressOfEmplyeeById(Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		/*
		String[] str = dao.getNameAndAddressOfEmplyeeById(empId);
		if(str.length==0 || str==null)
		{
			throw new EmployeeException("Employee not found");
		}
		else
		{
			return str;
		}
		*/
		return null;
	}

	@Override
	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		/*
		List<EmployeeDTO> list = dao.getNameAddressSalaryOfAllEmployee();
		if(list.size() > 0)
		{
			return list;
		}
		else
		{
			throw new EmployeeException("Employee list is empty");
		}
		*/
		return null;
	}
	

}

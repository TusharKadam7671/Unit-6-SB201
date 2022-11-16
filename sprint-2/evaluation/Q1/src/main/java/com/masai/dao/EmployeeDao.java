package com.masai.dao;

import java.util.List;

import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.model.Department;
import com.masai.model.Employee;

public interface EmployeeDao {
	
	public void addDepartment(Department dept);
	
	public void addEmployee(Employee emp);
	
	public void registerEmployeeTODepartment(int empId, int deptId)throws
	EmployeeException, DepartmentException;
	
	List<Employee> getAllEmployeeWithDeptName(String deptName)throws
	EmployeeException;
	
	Department getDepartmentDetailsByEmployeeId(int empId)throws
	DepartmentException;


}

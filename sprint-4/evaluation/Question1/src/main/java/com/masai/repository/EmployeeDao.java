package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;


@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	
	public List<Employee> findByAddress(String address);
	
	/*
	@Query("select e from Employee e where e.email=?1 and e.password=?2")
	public Employee loginEmployee(String email, String password) throws EmployeeException;
	
	@Query("select e.empName, e.address from Employee e where e.empId=?1")
	public String[] getNameAndAddressOfEmplyeeById(Integer empId)throws
	EmployeeException;
	
	@Query("select new com.masai.model.EmployeeDTO(e.empName,e.salary,e.address) from Employee e")
	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee()throws
	EmployeeException;
	*/
}

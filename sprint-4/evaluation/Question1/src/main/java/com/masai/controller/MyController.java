package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.service.EmployeeService;

@RestController
public class MyController {
	
	
	@Autowired
	private EmployeeService eService;
	
	
//	http://localhost:8888/employees
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> registerEmployeeHandler(@Valid @RequestBody Employee emp) throws EmployeeException
	{
		Employee saved = eService.registerEmployee(emp);
		return new ResponseEntity<Employee>(saved, HttpStatus.CREATED);
	}
	
	
//	http://localhost:8888/employees/6
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity<Employee> getEmployeeByIdHandler(@PathVariable("empId") Integer empId) throws EmployeeException
	{
		return new ResponseEntity<Employee>(eService.getEmployeeById(empId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployeeDetailsHandler() throws EmployeeException
	{
		return new ResponseEntity<List<Employee>>(eService.getAllEmployeeDetails(), HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<Employee> deleteEmployeeHandler(@PathVariable("empId") Integer empId) throws EmployeeException
	{
		return new ResponseEntity<Employee>(eService.deleteEmployeeById(empId), HttpStatus.CREATED);
	}
	
	@GetMapping("/employees/login/{email}/{password}")
	public ResponseEntity<Employee> loginEmployeeHandler(@PathVariable("email") String email,
			@PathVariable("password") String password) throws EmployeeException
	{
		return new ResponseEntity<Employee>(eService.loginEmployee(email, password), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getemployees/{address}")
	public ResponseEntity<List<Employee>> getEmployeeDetailsByAddress(@PathVariable("address") String address) throws EmployeeException
	{
		return new ResponseEntity<List<Employee>>(eService.getEmployeeDetailsByAddress(address), HttpStatus.CREATED);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployeeeHandler(@RequestBody Employee emp) throws EmployeeException
	{
		return new ResponseEntity<Employee>(eService.updateEmployee(emp), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getemployees2/{empId}")
	public ResponseEntity<String[]> getNameAndAddressofEmployeeHandler(@PathVariable("empId") Integer empId) throws EmployeeException
	{
		return new ResponseEntity<String[]>(eService.getNameAndAddressOfEmplyeeById(empId), HttpStatus.CREATED);
	}

}

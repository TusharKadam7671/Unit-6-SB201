package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public class RegisterEmployee {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        EmployeeDao dao = new EmployeeDaoImpl();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter employee name:");
        String name = sc.nextLine();
        
        System.out.println("Enter employee address:");
        String address = sc.nextLine();
        
        System.out.println("Enter employee salary:");
        int salary = sc.nextInt();
        
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        employee.setSalary(salary);
        
        try {
          Employee employee2 = dao.registerEmployee(employee);
          System.out.println(employee2);
          
      } catch (EmployeeException e) {
          // TODO Auto-generated catch block
          System.out.println(e.getMessage());
      }

    }

}

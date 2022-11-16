package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public class UpdateEmployee {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        EmployeeDao dao = new EmployeeDaoImpl();
        
        Scanner sc = new Scanner(System.in);
      
        System.out.println("Enter employee id:");
        int id = sc.nextInt();
        
        try {
          Employee employee2 = dao.getEmployeeById(id);

          if(employee2 != null)
          {
              
              System.out.println("Enter amount to increase salary");
              int salary = sc.nextInt();
              
              employee2.setSalary(employee2.getSalary()+salary);
              
              Employee updatedEmployee = dao.updateEmployee(employee2);
              
              System.out.println(updatedEmployee);
          }
          
      } catch (EmployeeException e) {
          // TODO Auto-generated catch block
          System.out.println(e.getMessage());
      }

    }

}

package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public class GetEmployeeById {
    
    public static void main(String[] args) {
        
        EmployeeDao dao = new EmployeeDaoImpl();
        
        Scanner sc = new Scanner(System.in);
      
        System.out.println("Enter employee id:");
        int id = sc.nextInt();
        
        try {
          Employee employee2 = dao.getEmployeeById(id);
          System.out.println(employee2);
          
      } catch (EmployeeException e) {
          // TODO Auto-generated catch block
          System.out.println(e.getMessage());
      }

    }

}

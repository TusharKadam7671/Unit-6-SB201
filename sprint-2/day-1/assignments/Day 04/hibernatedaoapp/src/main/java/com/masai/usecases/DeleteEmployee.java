package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public class DeleteEmployee {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        EmployeeDao dao = new EmployeeDaoImpl();
        
        Scanner sc = new Scanner(System.in);
      
        System.out.println("Enter employee id:");
        int id = sc.nextInt();
        
        try {
          Employee employee2 = dao.deleteEmployeeById(id);
          System.out.println("Employee with id "+id+" and name "+employee2.getName()+" is deleted successfully");
          
      } catch (EmployeeException e) {
          // TODO Auto-generated catch block
          System.out.println(e.getMessage());
      }


    }

}

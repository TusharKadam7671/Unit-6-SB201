package com.masai.main;

import java.util.Scanner;

import com.masai.usecases.DeleteEmployee;
import com.masai.usecases.GetAddress;
import com.masai.usecases.GiveBonus;
import com.masai.usecases.SaveEmp;

public class Main {
	
	public static void run()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n-----------------");
		
		System.out.println("Enter choice to continue");
		
		System.out.println("1.Save employee");
		System.out.println("2.Get employee address");
		System.out.println("3.Give bonus to employee");
		System.out.println("4.Delete employee");
		System.out.println("5.Exit");
		
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: SaveEmp.saveEmp();
		run();
		break;
		
		case 2: GetAddress.getAddress();
		run();
		break;
		
		case 3: GiveBonus.giveBons();
		run();
		break;
		
		case 4: DeleteEmployee.deleteEmployee();
		run();
		break;
		
		case 5: System.exit(0);
		break;
		
		default: run();
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		run();	

	}

}

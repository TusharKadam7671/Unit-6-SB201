package com.masai.main;

import java.util.Scanner;

import com.masai.usecases.DeleteById;
import com.masai.usecases.Deposit;
import com.masai.usecases.Findbyid;
import com.masai.usecases.Save;
import com.masai.usecases.Withdraw;

public class Main {

	public static void run() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter correct number to continue");

		System.out.println("1.findbyid");
		System.out.println("2.save account");
		System.out.println("3.delete account");
		System.out.println("4.withdraw");
		System.out.println("5.deposit");

		int n = sc.nextInt();

		switch (n) {
		case 1: 
			Findbyid.find();
			run();
			break;
		case 2:
			Save.save();
			run();
			break;
		case 3:
			DeleteById.delete();
			run();
			break;
		case 4:
			Withdraw.withdraw();
			run();
			break;
		case 5:
			Deposit.deposit();
			run();
			break;
		case 6:
			System.exit(0);
			break;

		default:
			System.out.println("Enter correct option");
			run();
			break;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("welcome");

		run();

	}

}

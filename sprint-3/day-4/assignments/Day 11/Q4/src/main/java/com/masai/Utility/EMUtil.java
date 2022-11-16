package com.masai.Utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
	
private static EntityManagerFactory emf;
	
	static
	{
		emf=Persistence.createEntityManagerFactory("app-Unit");
	}
	
	public static EntityManager provideEntityManager()
	{
		return emf.createEntityManager();
	}

	public static void main(String[] args) {
		
		System.out.println(provideEntityManager());
	}

}

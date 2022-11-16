package com.masai.connectivity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetConnection {
	
//	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("accountUnit");
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("accountUnit");
	
	public static EntityManagerFactory getConnection()
	{
		return emf;
	}

}

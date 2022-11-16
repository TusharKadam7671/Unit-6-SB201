package com.masai.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

public class Connection {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("empUnit");
	
	public static EntityManagerFactory getConnection()
	{
		return emf;
	}

}

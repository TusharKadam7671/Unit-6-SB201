package com.masai.EMUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.masai.model.Book;

public class EMUtil {
	
	private static EntityManagerFactory emf;
	
	static
	{
		emf=Persistence.createEntityManagerFactory("accountUnit");
	}

	public static EntityManager provideEntityManager()
	{
		return emf.createEntityManager();
	}
	
	public static void main(String[] args) {
		
//		System.out.println(provideEntityManager());
		
		/*
		EntityManager em = provideEntityManager();
		String jpql = "from Book";
		Query q = em.createQuery(jpql);
		List<Book> books = q.getResultList();
		System.out.println(books);
		*/
		
		/*
		EntityManager em = EMUtil.provideEntityManager();
		
		Book book = em.find(Book.class, 3);
		
		System.out.println(book);
		*/
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Book book = em.find(Book.class, 6);
		em.getTransaction().begin();
		em.remove(book);
		em.getTransaction().commit();
	}
}

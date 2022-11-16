package com.masai.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.EMUtil.EMUtil;
import com.masai.exception.BookException;
import com.masai.model.Book;


@RestController

@RequestMapping("/bookapp")
public class BookController {
	
//	http://localhost:8888/bookapp/books
	@PostMapping("/books")
	public ResponseEntity<String> createBook(@RequestBody Book book)
	{
		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		
		return new ResponseEntity<String>("Book added successfully",HttpStatus.ACCEPTED);
	}
	
	
//	http://localhost:8888/bookapp/books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		EntityManager em = EMUtil.provideEntityManager();
		
		String jpql = "select a from Book a";
		Query q = em.createQuery(jpql);
		List<Book> books = q.getResultList();
		
		if(books.size()==0)
		{
			throw new BookException("List of books is empty");
		}
		else
		{
			System.out.println(books);
			return new ResponseEntity<List<Book>>(books, HttpStatus.ACCEPTED);
		}
		
	}
	
	
//	http://localhost:8888/bookapp/books/3
	@GetMapping("/books/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId") Integer bookId)
	{
		EntityManager em = EMUtil.provideEntityManager();
		
		Book book = em.find(Book.class, bookId);
		if(book==null)
		{
			throw new BookException("Book not found with id :"+bookId);
		}
		else
		{
			return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
		}
	}
	
	
//	http://localhost:8888/bookapp/books/7
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable("bookId") Integer bookId)
	{
		EntityManager em = EMUtil.provideEntityManager();
		
		Book book = em.find(Book.class, bookId);
		
		if(book==null)
		{
			throw new BookException("Book not found with id :"+bookId);
		}
		else
		{
			em.getTransaction().begin();
			em.remove(book);
			em.getTransaction().commit();
			return new ResponseEntity<String>("Book deleted successfully", HttpStatus.CREATED);
		}
	}
	
//	http://localhost:8888/bookapp/books/5
	@PutMapping("/books/{bookId}")
	public ResponseEntity<String> updateBookById(@RequestBody Book book2, @PathVariable("bookId") Integer bookId)
	{
		EntityManager em = EMUtil.provideEntityManager();
		
		Book book = em.find(Book.class, bookId);
		
		if(book==null)
		{
			throw new BookException("Book not found with id :"+bookId);
		}
		else
		{
			em.getTransaction().begin();
			book.setName(book2.getName());
			book.setAutor(book2.getAutor());
			book.setPrice(book2.getPrice());
			em.getTransaction().commit();
			return new ResponseEntity<String>("Book updated successfully", HttpStatus.ACCEPTED);
		}
	}
	

}

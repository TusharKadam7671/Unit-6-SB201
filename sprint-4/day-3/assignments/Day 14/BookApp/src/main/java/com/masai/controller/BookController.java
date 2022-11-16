package com.masai.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BookException;
import com.masai.model.Book;

@RestController

@RequestMapping("/bookservice") //reflect in uri.

public class BookController {
	
	private List<Book> books = new ArrayList<>();
	
	
	public BookController()
	{
		books.add(new Book(101, "C++", "Nitesh", "Rajput Publication", "Computer Programming", 1500, 240, "G452"));
		books.add(new Book(102, "Java", "James Gosling", "Oracle Publication", "Computer Programming", 2530, 500, "J654"));
		books.add(new Book(103, "Baahubali", "Prabhas", "SSR Publication", "History", 1900, 250, "B3000"));
	}
	
	
//	http://localhost:8888/bookservice/books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		if(books.size()==0)
		{
			throw new BookException("Book list is empty");
		}
		else
		{
		return new ResponseEntity<List<Book>>(books,HttpStatus.ACCEPTED);
		}
	}
	
	
//	http://localhost:8888/bookservice/books/103
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById( @PathVariable("id") Integer bookId)
	{
		List<Book> list = books.stream().filter(b -> b.getBookId()==bookId).collect(Collectors.toList());
		
		if(list.size()==0)
		{
			throw new BookException("Book Not Found");
		}
		else
		{
		return new ResponseEntity<Book>(list.get(0),HttpStatus.FOUND);
		}
	
	}
	
//	http://localhost:8888/bookservice/books
	@PostMapping("/books")
	public ResponseEntity<String> createBook( @RequestBody Book book)
	{
		
		books.add(book);
		
		return new ResponseEntity<String>("Book added successfully",HttpStatus.ACCEPTED);
		
	}
	
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBook( @PathVariable("id") Integer bookId)
	{
		
		boolean flag = books.removeIf( b-> b.getBookId()==bookId);
		
		if(flag)
		{
			return new ResponseEntity<String>( "Book deleted successfully",HttpStatus.ACCEPTED);
		}
		else
		{
			
			throw new BookException("Book not found with id "+bookId);
		}
		
	}
	
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(
			@PathVariable("id") Integer bookId,
//			@PathVariable("price") Integer price,
			@RequestParam("price") Integer Price
			)
	{
		boolean flag = true;
		
		Book book = null;
		
		for(Book bk : books)
		{
			if(bk.getBookId()==bookId)
			{
			
				bk.setPrice(Price);
				
				flag = false;
				
				book = bk;
			}
		}
		
		if(flag)
		{
			throw new BookException ("Book does not exists with id "+bookId);
		}
		else
		{
			return new ResponseEntity<Book>(book,HttpStatus.CREATED);
		}
	
	}

}

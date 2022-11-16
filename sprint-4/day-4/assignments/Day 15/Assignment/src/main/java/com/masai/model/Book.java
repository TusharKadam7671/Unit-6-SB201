package com.masai.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	private String name;
	private String autor;
	private Integer price;
	
	
	public Book() {
		super();
	}


	public Book(Integer bookId, String name, String autor, Integer price) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.autor = autor;
		this.price = price;
	}


	public Integer getBookId() {
		return bookId;
	}


	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", autor=" + autor + ", price=" + price + "]";
	}
	
	

}

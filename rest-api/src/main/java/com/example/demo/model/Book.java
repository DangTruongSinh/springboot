package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.constant.TypeBook;
import com.example.demo.constraint.anotation.LimitTypeBook;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "name is not null")
	@Size(min = 3,message = "name must have greater than 3 letters")
	private String name;
	@NotBlank(message = "author is not null")
	private String author;
	@LimitTypeBook(targetClassType = TypeBook.class,message = "type book not match!")
	private String typeBook;
	
	public String getTypeBook() {
		return typeBook;
	}
	public void setTypeBook(String typeBook) {
		this.typeBook = typeBook;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}
	
}

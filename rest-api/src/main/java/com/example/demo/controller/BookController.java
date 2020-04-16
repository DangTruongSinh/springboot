package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@Validated
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> findAll()
	{
		return bookService.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Book findOne(@PathVariable @Min(1) Long id)
	{
		return bookService.findById(id);
	}
	
	@PostMapping("/books")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Book newBook(@RequestBody @Valid Book book)
	{
		return bookService.save(book);
	}
	
	@PutMapping("/books")
	public Book updateBook(@RequestBody @Valid Book book)
	{
		return bookService.update(book);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable Long id)
	{
		 bookService.delete(id);
	}
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.notfound.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRes;
	
	@Transactional
	public Book save(Book book)
	{
		bookRes.save(book);
		return book;
	}
	
	@Transactional
	public Book update(Book book)
	{
		try {
			bookRes.save(book);
		}
		catch (EmptyResultDataAccessException ex) {
			throw new BookNotFoundException(book.getId());
		}
		return book;
	}
	
	@Transactional
	public void delete(Long id)
	{
		try {
			bookRes.deleteById(id);
		}
		catch (EmptyResultDataAccessException ex) {
			throw new BookNotFoundException(id);
		}
	}
	
	public List<Book> findAll()
	{
		return bookRes.findAll();
	}
	
	public Book findById(Long id)
	{
		return bookRes.findById(id).orElseThrow(()->new BookNotFoundException(id));
	}
}

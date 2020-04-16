package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Component
public class WebConfig {
	
	@Value("${spring.profiles.active}")
	private String mode;
	
	@Autowired
	private BookService bookService;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		if(mode.equals("dev"))
		{
			bookService.save(new Book("doremon1", "sinh1"));
			bookService.save(new Book("doremon2", "sinh2"));
			bookService.save(new Book("doremon3", "sinh3"));
			bookService.save(new Book("doremon4", "sinh4"));
		}
	}
	
}

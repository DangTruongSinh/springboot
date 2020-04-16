package com.example.demo.exception.notfound;

public class BookNotFoundException extends AbstractNotFoundException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(Long id) {
		super("book not exits id:"+id);
	}

}

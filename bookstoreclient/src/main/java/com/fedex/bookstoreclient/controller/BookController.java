package com.fedex.bookstoreclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.bookstoreclient.service.BookService;

@RestController
public class BookController {
	static Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBookForBookName(@RequestParam(value="bookName", defaultValue="") String bookName) {
		logger.info("Calling GET method");
		String books = bookService.getBooksForBookName(bookName);

		if (books != null && books.length() > 0) {
			logger.info("Call to GET method SUCCESS");
		}

		return books;
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public void insertBook(@RequestBody Object book) {
		logger.info("Calling POST method");
		try {
			bookService.insertBooks(book);
			logger.info("Call to POST method SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

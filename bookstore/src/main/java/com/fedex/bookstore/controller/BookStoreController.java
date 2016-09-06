package com.fedex.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.bookstore.model.Book;
import com.fedex.bookstore.repository.BookstoreMongoRepository;

@RestController
public class BookStoreController {
	static Logger logger = LoggerFactory.getLogger(BookStoreController.class);
	@Autowired
	private BookstoreMongoRepository bookstoreMongoRepository;
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> findBookForBookName(@RequestParam(value="bookName", defaultValue="") String bookName) {
		logger.info("Calling GET method");
		List<Book> books = new ArrayList<Book>();
		
		if (bookName != null && bookName.trim().length() > 0) {
			Book book = bookstoreMongoRepository.findByBookName(bookName);
			books.add(book);
		} else {
			books = bookstoreMongoRepository.findAll();
		}

		if (books != null && books.size() > 0) {
			logger.info("Call to GET method SUCCESS");
		}

		return books;
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public void insertBook(@RequestBody Book book) {
		logger.info("Calling POST method");
		try {
			bookstoreMongoRepository.insert(book);
			logger.info("Call to POST method SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.PUT)
	public void updateBook(@RequestBody Book book) {
		logger.info("Calling PUT method");
		try {
			bookstoreMongoRepository.save(book);
			logger.info("Call to PUT method SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable(value="id") String id) {
		logger.info("Calling DELETE method");
		try {
			bookstoreMongoRepository.delete(id);
			logger.info("Call to DELETE method SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

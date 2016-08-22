package com.fedex.bookstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.bookstore.model.Book;
import com.fedex.bookstore.repository.BookstoreRepository;

@RestController
public class BookController {
	static Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookstoreRepository bookstoreRepository;
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public Book readBookForBookName(String bookName) {
		Book book = bookstoreRepository.findByBookName(bookName);
		return book;
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public void saveBook(Book book) {
		bookstoreRepository.save(book);
	}
	
	@RequestMapping(value = "/recommended", method = RequestMethod.GET)
	public String readingList() {
		logger.info("Providing reading list from service");
		try {
			//If setting this more than the limit set in command properties of client, client 
			//call will go to fall back
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

		return "Cloud Native Java from service (O'Reilly)";
	}
}

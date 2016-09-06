package com.fedex.bookstore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.fedex.bookstore.model.Book;

public interface BookstoreMongoRepository extends MongoRepository<Book, String> {
	public Book findByBookName(String bookName);
	public List<Book> findByAuthorName(String authorName);
	public List<Book> findByBookType(String bookType);
}

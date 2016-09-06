package com.fedex.bookstore.model;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class Book {
	private static AtomicLong COUNTER = new AtomicLong(0L);
	@Id private String id;
	private String bookName;
	private String authorName;
	private String bookType;
	
	@PersistenceConstructor
	public Book() {
		if (id != null && id.trim().length() > 0) {
			//Do nothing
		} else {
			this.id = String.valueOf(COUNTER.incrementAndGet());
		}
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getBookType() {
		return bookType;
	}
	
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", bookType=" + bookType
				+ "]";
	}
}

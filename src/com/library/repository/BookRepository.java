package com.library.repository;

import com.library.model.Book;

import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    private Map<String, Book> bookMap;
    public BookRepository() {
        this.bookMap=new HashMap<String, Book>();
    }

    //create
    public void addBook(Book book) {
        this.bookMap.put(book.getISBN(), book);
    }

    //read
    public Book getBook(String ISBN) {
        return this.bookMap.get(ISBN);
    }

    //update
    public void updateBook(Book book) {
        this.bookMap.put(book.getISBN(), book);
    }

    //delete
    public void deleteBook(String ISBN) {
        this.bookMap.remove(ISBN);
    }
}


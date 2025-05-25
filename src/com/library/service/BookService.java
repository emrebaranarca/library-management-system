package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.service.interfaces.IBookService;


public class BookService implements IBookService {

    private BookRepository bookRepository;
    public BookService() {
        this.bookRepository = new BookRepository();
    }


    @Override
    public void createBook(Book book) {
        this.bookRepository.addBook(book);
    }

    @Override
    public Book getBook(String ISBN) {
        return this.bookRepository.getBook(ISBN);
    }

    @Override
    public void updateBook(Book book) {
        this.bookRepository.updateBook(book);
    }

    @Override
    public void deleteBook(String ISBN) {
        this.bookRepository.deleteBook(ISBN);
    }

}

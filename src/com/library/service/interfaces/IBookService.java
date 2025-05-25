package com.library.service.interfaces;

import com.library.model.Book;

public interface IBookService {

    //post
    void createBook(Book book);

    //get
    public Book getBook(String ISBN);

    //update
    public void updateBook(Book book);

    //delete
    public void deleteBook(String ISBN);
}

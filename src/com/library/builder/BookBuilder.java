package com.library.builder;

import com.library.enums.BookStatus;
import com.library.model.Book;

public class BookBuilder {
    private final String ISBN;
    private final String title;
    private final String author;
    private final String publisher;
    private final int pages;
    private final int year;
    private final String genre;
    private BookStatus status;
    private String location;


    public BookBuilder(String isbn, String title, String author,
                       String publisher, int pages, int year,
                       String genre, BookStatus status, String location)
    {
        ISBN = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.year = year;
        this.genre = genre;
        this.status = status;
        this.location = location;
    }

    public BookBuilder setStatus(BookStatus status) {
        this.status=status;
        return this;
    }

    public BookBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    public Book build() {
        return new Book(this);
    }


    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public BookStatus getStatus() {
        return status;
    }

    public String getLocation() {
        return location;
    }
}

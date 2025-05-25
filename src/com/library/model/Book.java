package com.library.model;

import com.library.builder.BookBuilder;
import com.library.enums.BookStatus;

public class Book {
    private final String ISBN;
    private final String title;
    private final String author;
    private final String publisher;
    private final int pages;
    private final int year;
    private final String genre;
    private BookStatus status;
    private String location;

    public Book(BookBuilder builder) {
        this.ISBN = builder.getISBN();
        this.title = builder.getTitle();
        this.author = builder.getAuthor();
        this.publisher = builder.getPublisher();
        this.pages = builder.getPages();
        this.year = builder.getYear();
        this.genre = builder.getGenre();
        this.status = builder.getStatus();
        this.location = builder.getLocation();
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

    @Override
    public String toString() {
        return "com.library.model.Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pages=" + pages +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", status=" + status +
                ", location='" + location + '\'' +
                '}';
    }

    public String getLocation() {
        return location;
    }
}

package com.library.service;

import com.library.builder.BookBuilder;
import com.library.builder.StandardBuilder;
import com.library.builder.StudentBuilder;
import com.library.builder.TeacherBuilder;
import com.library.enums.BookStatus;
import com.library.model.*;
import com.library.model.params.UserCreationParams;
import com.library.service.interfaces.IBookService;
import com.library.service.interfaces.IUserService;

import java.util.List;

public class LibraryService {
    private final IUserService userService;
    private final IBookService bookService;

    //LOUSE COUPLİNG
    public LibraryService(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    //user operations

    //! create
    public void registerStandardUser(UserCreationParams params) {
        StandardBuilder standardBuilder=new StandardBuilder(
                params.getIdentityNumber(), params.getFirstName(), params.getLastName())
                .setPhoneNumber(params.getPhoneNumber()).setUsername(params.getUsername())
                .setEmail(params.getEmail());

        Standard standardUser=standardBuilder.build();

        this.userService.addUser(standardUser);

        System.out.println("Standart kullanıcı eklendi: " + params.getFirstName() + " " + params.getLastName());


    }

    public void registerTeacherUser(UserCreationParams params, String major) {
        TeacherBuilder teacherBuilder=new TeacherBuilder(params.getIdentityNumber(),
                params.getFirstName(), params.getLastName())
                .setPhoneNumber(params.getPhoneNumber()).setUsername(params.getPhoneNumber())
                .setMajor(major).setEmail(params.getEmail());

        Teacher teacherUser=teacherBuilder.build();
        this.userService.addUser(teacherUser);
        System.out.println("Teacher user eklendi: " + params.getFirstName() + " " +
                params.getLastName());
    }

    public void registerStudentUser(UserCreationParams params, String school) {
        StudentBuilder studenBuilder=new StudentBuilder(params.getIdentityNumber(), params.getFirstName(),
                params.getLastName())
                .setPhoneNumber(params.getPhoneNumber()).setUsername(params.getUsername())
                .setEmail(params.getEmail()).setSchool(school);

        Student studentUser=studenBuilder.build();

        this.userService.addUser(studentUser);

        System.out.println("Öğrenci kullanıcı eklendi: " + params.getFirstName() + " " +
                params.getLastName());

    }

    //! read
    public User findUserByID(String identityNumber) {
        return userService.getUser(identityNumber);
    }

    //public List<User> findAllUser() {}

    //! update
    public void updateUser(User user) {
        this.userService.updateUser(user);
        System.out.println("Kullanıcı bilgileri güncellendi: " + user.getFirstName() + " " + user.getLastName());

    }

    //! delete
    public void deleteUser(String identityNumber) {
        this.userService.deleteUser(identityNumber);
    }


    //book operations

    public void addBook(
            String isbn, String title, String author, String publisher,
            int pages, int year, String genre, String location
    ) {
        BookBuilder builder = new BookBuilder(
                isbn, title, author, publisher, pages, year, genre,
                BookStatus.ONSHELF, location);
        Book newBook = builder.build();
        bookService.createBook(newBook);
        System.out.println("Kitap başarıyla eklendi: " + title);
    }

    public Book findBookByISBN(String isbn) {
        return bookService.getBook(isbn);
    }

    public void updateBookInfo(
            String isbn, String title, String author, String publisher,
            int pages, int year, String genre, BookStatus status, String location
    ) {
        BookBuilder builder = new BookBuilder(
                isbn, title, author, publisher, pages, year, genre,
                status, location);
        Book updatedBook = builder.build();
        bookService.updateBook(updatedBook);
        System.out.println("Kitap bilgileri güncellendi: " + title);
    }

    public void removeBook(String isbn) {
        Book book = bookService.getBook(isbn);
        if (book != null) {
            bookService.deleteBook(isbn);
            System.out.println("Kitap silindi: " + book.getTitle());
        } else {
            System.out.println("Kitap bulunamadı, ISBN: " + isbn);
        }
    }













}

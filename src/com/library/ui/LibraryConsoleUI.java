package com.library.ui;

import com.library.model.Book;
import com.library.model.User;
import com.library.model.params.UserCreationParams;
import com.library.service.LibraryService;
import com.library.service.UserService;

public class LibraryConsoleUI {
    private final ConsoleInputHandler inputHandler;
    private final LibraryService libraryService;
    private boolean run=true;


    public LibraryConsoleUI(ConsoleInputHandler inputHandler, LibraryService libraryService) {
        this.inputHandler = inputHandler;
        this.libraryService = libraryService;
    }

    public void start() {
        boolean run=true;

        System.out.println("İstanbul Merkez Kütüphanesi Yönetim Sistemi'ne Hoş Geldiniz!");

        while(run){
            displayMainMenu();
            int choice = inputHandler.getIntInput("Lütfen bir seçenek girin: ");
            switch (choice) {
                case 1: bookManagement(); break;
                case 2: userManagement(); break;
                case 3: searchManagement(); break;
                case 0:run=false;break;
                default:
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
            }
        }
    }

    // help operations in main
    public void displayMainMenu() {
        System.out.println("\n===== ANA MENÜ =====");
        System.out.println("1. Kitap Yönetimi");
        System.out.println("2. Kullanıcı Yönetimi");
        System.out.println("3. Arama");
        System.out.println("0. Çıkış");
    }

    public  void bookManagement(){
        boolean run=false;
        while(!run){
            System.out.println("\n===== KİTAP YÖNETİMİ =====");
            System.out.println("1. Yeni Kitap Ekle");
            System.out.println("2. Kitap Bilgilerini Güncelle");
            System.out.println("3. Kitap Sil");
            System.out.println("0. Ana Menüye Dön");

            int choice = inputHandler.getIntInput("Lütfen bir seçenek girin: ");

            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 0:
                    run = true;
                    break;
                default:
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
            }
        }

    }

    public  void userManagement(){
        boolean run=false;
        while(!run){
            System.out.println("\n===== KULLANICI YÖNETİMİ =====");
            System.out.println("1. Yeni Standart Kullanıcı Ekle");
            System.out.println("2. Yeni Öğrenci Kullanıcı Ekle");
            System.out.println("3. Yeni Öğretmen Kullanıcı Ekle");
            System.out.println("4. Kullanıcı Bilgilerini Görüntüle");
            System.out.println("5. Kullanıcı Sil");
            System.out.println("0. Ana Menüye Dön");

            int choice = inputHandler.getIntInput("Lütfen bir seçenek girin: ");

            switch (choice) {
                case 1:
                    addStandardUser();
                    break;
                case 2:
                    addStudentUser();
                    break;
                case 3:
                    addTeacherUser();
                    break;
                case 4:
                    viewUserDetails();
                    break;
                case 5:
                    deleteUser();
                    break;
                case 0:
                    run = true;
                    break;
                default:
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
            }
        }
    }

    public  void searchManagement(){
        boolean run = false;

        while (!run) {
            System.out.println("\n===== ARAMA =====");
            System.out.println("1. ISBN ile Kitap Ara");
            System.out.println("2. Kimlik Numarası ile Kullanıcı Ara");
            System.out.println("0. Ana Menüye Dön");

            int choice = inputHandler.getIntInput("Lütfen bir seçenek girin: ");

            switch (choice) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    searchUser();
                    break;
                case 0:
                    run = true;
                    break;
                default:
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
            }
        }
    }


    // book operations in library service
     public void addNewBook() {
        System.out.println("\n=== Yeni Kitap Ekle ===");

        String isbn = inputHandler.getStringInput("ISBN: ");
        String title = inputHandler.getStringInput("Başlık: ");
        String author = inputHandler.getStringInput("Yazar: ");
        String publisher = inputHandler.getStringInput("Yayınevi: ");
        int pages = inputHandler.getIntInput("Sayfa Sayısı: ");
        int year = inputHandler.getIntInput("Yayın Yılı: ");
        String genre = inputHandler.getStringInput("Tür: ");
        String location = inputHandler.getStringInput("Raf Konumu: ");

        libraryService.addBook(isbn, title, author, publisher, pages, year, genre, location);
    }

     public void updateBook() {
        System.out.println("\n=== Kitap Güncelle ===");
        String isbn = inputHandler.getStringInput("Güncellenecek Kitabın ISBN Numarası: ");
        Book book = libraryService.findBookByISBN(isbn);

        if (book != null) {
            System.out.println("Kitap Bulundu: " + book.getTitle());
            System.out.println("Yeni değerleri girin (değiştirmek istemediğiniz alanlar için doğrudan Enter tuşuna basın):");

            String title = inputHandler.getStringInputWithDefault("Başlık", book.getTitle());
            String author = inputHandler.getStringInputWithDefault("Yazar", book.getAuthor());
            String publisher = inputHandler.getStringInputWithDefault("Yayınevi", book.getPublisher());
            int pages = inputHandler.getIntInputWithDefault("Sayfa Sayısı", book.getPages());
            int year = inputHandler.getIntInputWithDefault("Yayın Yılı", book.getYear());
            String genre = inputHandler.getStringInputWithDefault("Tür", book.getGenre());
            String location = inputHandler.getStringInputWithDefault("Raf Konumu", book.getLocation());

            libraryService.updateBookInfo(isbn, title, author, publisher, pages, year, genre, book.getStatus(), location);
        } else {
            System.out.println("Kitap bulunamadı!");
        }
    }

     public void deleteBook() {
        System.out.println("\n=== Kitap Sil ===");
        String isbn = inputHandler.getStringInput("Silinecek Kitabın ISBN Numarası: ");
        Book book = libraryService.findBookByISBN(isbn);

        if (book != null) {
            System.out.println("Kitap Bulundu: " + book.getTitle());
            String confirm = inputHandler.getStringInput("Bu kitabı silmek istediğinizden emin misiniz? (E/H): ");

            if (confirm.equalsIgnoreCase("E")) {
                libraryService.removeBook(isbn);
            } else {
                System.out.println("Silme işlemi iptal edildi.");
            }
        } else {
            System.out.println("Kitap bulunamadı!");
        }
    }

     public void searchBook() {
        System.out.println("\n=== ISBN ile Kitap Ara ===");
        String isbn = inputHandler.getStringInput("ISBN: ");
        Book book = libraryService.findBookByISBN(isbn);

        if (book != null) {
            System.out.println("Kitap Bulundu:");
            System.out.println(book);
        } else {
            System.out.println("Kitap bulunamadı!");
        }
    }

    //user operations in library service
    public void addStandardUser() {
        System.out.println("\n=== Yeni Standart Kullanıcı Ekle ===");
        String identityNumber = inputHandler.getStringInput("Kimlik Numarası: ");
        String firstName = inputHandler.getStringInput("Ad: ");
        String lastName = inputHandler.getStringInput("Soyad: ");
        String username=inputHandler.getStringInput("Kullanıcı adı: ");
        String email = inputHandler.getStringInput("E-posta: ");
        String phone = inputHandler.getStringInput("Telefon: ");

        // UserCreationParams nesnesi oluştur
        UserCreationParams params = new UserCreationParams(
                identityNumber, firstName, lastName, email, phone, username
        );

        libraryService.registerStandardUser(params);
    }

    public void addStudentUser() {
        System.out.println("\n=== Yeni Öğrenci Kullanıcı Ekle ===");
        String identityNumber = inputHandler.getStringInput("Kimlik Numarası: ");
        String firstName = inputHandler.getStringInput("Ad: ");
        String lastName = inputHandler.getStringInput("Soyad: ");
        String username=inputHandler.getStringInput("Kullanıcı adı: ");
        String email = inputHandler.getStringInput("E-posta: ");
        String phone = inputHandler.getStringInput("Telefon: ");
        String school = inputHandler.getStringInput("Okul: ");

        UserCreationParams params = new UserCreationParams(identityNumber, firstName, lastName,username,
                phone, email);
        libraryService.registerStudentUser(params,school);
    }

    public void addTeacherUser() {
        System.out.println("\n=== Yeni Öğretmen Kullanıcı Ekle ===");
        String identityNumber = inputHandler.getStringInput("Kimlik Numarası: ");
        String firstName = inputHandler.getStringInput("Ad: ");
        String lastName = inputHandler.getStringInput("Soyad: ");
        String username=inputHandler.getStringInput("Kullanıcı adı: ");
        String email = inputHandler.getStringInput("E-posta: ");
        String phone = inputHandler.getStringInput("Telefon: ");
        String major = inputHandler.getStringInput("Branş: ");

        UserCreationParams params = new UserCreationParams(identityNumber, firstName, lastName, username,
                phone, email);

        libraryService.registerTeacherUser(params,major);
    }

    public void viewUserDetails() {
        System.out.println("\n=== Kullanıcı Bilgilerini Görüntüle ===");
        String identityNumber = inputHandler.getStringInput("Kullanıcı Kimlik Numarası: ");
        User user = libraryService.findUserByID(identityNumber);

        if (user != null) {
            System.out.println("Kullanıcı Bilgileri:");
            System.out.println(user);
        } else {
            System.out.println("Kullanıcı bulunamadı!");
        }
    }

    public void deleteUser() {
        System.out.println("\n=== Kullanıcı Sil ===");
        String identityNumber = inputHandler.getStringInput("Silinecek Kullanıcının Kimlik Numarası: ");
        User user = libraryService.findUserByID(identityNumber);

        if (user != null) {
            System.out.println("Kullanıcı Bulundu: " + user.getFirstName() + " " + user.getLastName());
            String confirm = inputHandler.getStringInput("Bu kullanıcıyı silmek istediğinizden emin misiniz? (E/H): ");

            if (confirm.equalsIgnoreCase("E")) {
                libraryService.deleteUser(identityNumber);
            } else {
                System.out.println("Silme işlemi iptal edildi.");
            }
        } else {
            System.out.println("Kullanıcı bulunamadı!");
        }
    }

    public void searchUser() {
        System.out.println("\n=== Kimlik Numarası ile Kullanıcı Ara ===");
        String identityNumber = inputHandler.getStringInput("Kimlik Numarası: ");
        User user = libraryService.findUserByID(identityNumber);

        if (user != null) {
            System.out.println("Kullanıcı Bulundu:");
            System.out.println(user);
        } else {
            System.out.println("Kullanıcı bulunamadı!");
        }
    }



}

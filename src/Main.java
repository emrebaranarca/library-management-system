import com.library.builder.*;
import com.library.model.*;
import com.library.service.BookService;
import com.library.service.LibraryService;
import com.library.service.UserService;
import com.library.ui.ConsoleInputHandler;
import com.library.ui.LibraryConsoleUI;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Dependency initialization
        //servis başlatma kodları
        UserService userService = new UserService();
        BookService bookService = new BookService();
        LibraryService libraryService=new LibraryService(userService,bookService);

        // UI initialization
        //arayüz kullanımı
        //maintability code
        Scanner scanner = new Scanner(System.in);
        ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler(scanner);
        LibraryConsoleUI libraryConsoleUI = new LibraryConsoleUI(consoleInputHandler, libraryService);

        //starting app
        libraryConsoleUI.start();


        //scanner kapatma
        scanner.close();
    }

}
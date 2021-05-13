package info.library;

import info.library.application.Application;
import info.library.service.BookService;
import info.library.service.BookServiceImpl;
import info.library.service.FillingDatabase;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
     BookService bookService = new BookServiceImpl();
        try {
            FillingDatabase.fillIn();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Application.start(bookService);
    }
}

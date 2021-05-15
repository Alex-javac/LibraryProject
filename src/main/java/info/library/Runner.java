package info.library;

import info.library.application.Application;
import info.library.dao.BookDao;
import info.library.dao.BookDaoImpl;
import info.library.model.books.Book;
import info.library.model.books.Books;
import info.library.service.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        try {
            FillingDatabase.fillIn();
        } catch (IOException e) {
            e.printStackTrace();
        }
    Application.start();
    }
}

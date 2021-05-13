package info.library.service;

import info.library.application.Application;
import info.library.dao.BookDao;
import info.library.dao.BookDaoImpl;
import info.library.model.books.Book;
import info.library.model.books.Genre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();


    @Override
    public void fetchBookByID(int id) {
        Book book;
        try {
            book = bookDao.getBookByID(id);
            if (book != null) {
                System.out.println(book);
            } else {
                System.out.println("Книга с таким ID отсутствует в БД");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fetchBooksByGenre() {
        List<Book> books = new ArrayList<>();
        try {
            System.out.print("Введите жанр книг: ");
            String genre = Application.scanner.nextLine();
            books.addAll(bookDao.getBooksByGenre(Genre.valueOf(genre.toUpperCase())));
        } catch (IllegalArgumentException e) {
            System.out.println("Выбирите жанр из предложеных:");
            for (Genre genre : Genre.values()) {
                System.out.print(genre + " ");
            }
            System.out.println();
            fetchBooksByGenre();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        books.forEach(System.out::println);
    }

    @Override
    public void fetchBooksByTitle() {
        List<Book> books = new ArrayList<>();
        try {
            System.out.print("Введите имя Автора книг: ");
            String title = Application.scanner.nextLine();
            books.addAll(bookDao.getBooksByTitle(title));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        books.forEach(System.out::println);
    }

    @Override
    public void fetchBooksByAuthor() {
        List<Book> books = new ArrayList<>();
        try {
            System.out.print("Введите имя Автора книг: ");
            String author = Application.scanner.nextLine();
            books.addAll(bookDao.getBooksByAuthor(author));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        books.forEach(System.out::println);
    }

    @Override
    public void fetchAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            books.addAll(bookDao.getAllBooks());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        books.forEach(System.out::println);
    }

    @Override
    public void delete(int id) {
        try {
            Book book = bookDao.getBookByID(id);
            if (book != null && bookDao.delete(book)) {
                System.out.println("Книга успешно удалена !!!!!");
            } else {
                System.out.println("Что-то пошло не так");
                System.out.println("Книга с таким ID отсутствует в БД");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id) {
        try {
            Book book = bookDao.getBookByID(id);
            if (book != null) {
                System.out.print("Новый жанр книги: ");
                String genre = Application.scanner.nextLine();
                book.setGenre(Genre.valueOf(genre.toUpperCase()));
                System.out.print("Новое название книги: ");
                String title = Application.scanner.nextLine();
                book.setTitle(title);
                System.out.print("Имя Автора книги: ");
                String author = Application.scanner.nextLine();
                book.setAuthor(author);

                if (bookDao.update(book)) {
                    System.out.println("Книга успешно отредактирована !!!!!");
                } else {
                    System.out.println("Что-то пошло не так");
                }
            } else {
                System.out.println("Книга с таким ID отсутствует в БД");
            }
        } catch (SQLException e) {
            System.out.println("Название книги, Имя автора не должны быть пустыми полями.");
            update(id);

        } catch (IllegalArgumentException e) {
            System.out.println("Выбирите жанр из предложеных:");
            for (Genre genre : Genre.values()) {
                System.out.print(genre + " ");
            }
            System.out.println();
            update(id);
        }
    }

    @Override
    public void create() {
        try {
            Book book = new Book();
            Scanner scanner = new Scanner(System.in);
            System.out.print("жанр книги: ");
            String genre = scanner.nextLine();
            book.setGenre(Genre.valueOf(genre.toUpperCase()));
            System.out.print("название книги: ");
            String title = scanner.nextLine();
            book.setTitle(title);
            System.out.print("Имя Автора книги: ");
            String author = scanner.nextLine();
            book.setAuthor(author);

            if (bookDao.create(book)) {
                System.out.println("Книга успешно добавлена в БД !!!!!");
            } else {
                System.out.println("Что-то пошло не так");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Выбирите жанр из предложеных:");
            for (Genre genre : Genre.values()) {
                System.out.print(genre + " ");
            }
            System.out.println();
            create();
        }

    }
}

package info.library.service;

import info.library.application.Application;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ApplicationServiceImpl implements ApplicationService {
    BookService service = new BookServiceImpl();
    @Override
    public void sortBooks() {
        System.out.println("Вывод книг:");
        System.out.println("1) все книги одного Жанра");
        System.out.println("2) все книги одного Автора");
        System.out.println("3) все книги одного Названия");
        System.out.println("4) одну книгу по ID");
        System.out.println("5) все книги");
        System.out.println("6) Вернуться в главное меню");
        String num = Application.scanner.nextLine();

        switch (num) {
            case "1":
                service.fetchBooksByGenre();
                break;
            case "2":
                service.fetchBooksByAuthor();
                break;
            case "3":
                service.fetchBooksByTitle();
                break;
            case "4":
                getOneBook();
                break;
            case "5":
                service.fetchAllBooks();
                break;
            case "6":
                break;
            default:
                System.out.println("Введите цифру которая соответствует нужному вам действию!");
                sortBooks();
        }

    }

    @Override
    public void addBook() {
        if (isContinue()) {
            service.create();
        }
    }

    @Override
    public void redactor() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ввидите id книги которую нужно отредактировать");
            System.out.print("ID : ");
            int idRedactor = scanner.nextInt();
            if (isContinue()) {
                service.update(idRedactor);
            }
        } catch (InputMismatchException e) {
            System.out.println("ID состоит из цифр");
            System.out.println("Попробуйте еще раз");
            redactor();
        }
    }

    @Override
    public void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите ID книги: ");
            int id = scanner.nextInt();
            if (isContinue()) {
                service.delete(id);
            }
        } catch (InputMismatchException e) {
            System.out.println("ID состоит из цифр");
            System.out.println("Попробуйте еще раз");
            deleteBook();
        }
    }

    @Override
    public void getOneBook() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите ID книги: ");
            int id = scanner.nextInt();
            if (isContinue()) {
                service.fetchBookByID(id);
            }
        } catch (InputMismatchException e) {
            System.out.println("ID состоит из цифр");
            System.out.println("Попробуйте еще раз");
            getOneBook();
        }
    }

    private boolean isContinue() {
        boolean flag = false;
        System.out.println("Нажмите \"1\" чтобы продолжить");
        System.out.println("Нажмите \"2\" чтоб вернуться в главное меню");
        String num = Application.scanner.nextLine();
        switch (num) {
            case "1":
                flag = true;
                break;
            case "2":
                flag = false;
                break;
            default:
                isContinue();
        }
        return flag;
    }

}

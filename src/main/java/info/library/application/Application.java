package info.library.application;

import info.library.service.BookService;

import java.util.*;

public class Application {
    public static void start(BookService service) {
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите действие:");
            System.out.println("1) Вывод книг.");
            System.out.println("2) Добавление книги.");
            System.out.println("3) Удаление книги.");
            System.out.println("4) Редактирование книги.");
            System.out.println("5) Выход.");
            String num = scanner.nextLine();
            switch (num) {
                case "1":
                    sortBooks(service);
                    break;
                case "2":
                    addBook(service);
                    break;
                case "3":
                    deleteBook(service);
                    break;
                case "4":
                    redactor(service);
                    break;
                case "5":
                    flag = false;
                    return;
                default:
                    System.out.println("Введите цифру которая соответствует нужному вам действию!");
            }
        }
    }

    private static void sortBooks(BookService service) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вывод книг:");
        System.out.println("1) все книги одного Жанра");
        System.out.println("2) все книги одного Автора");
        System.out.println("3) все книги одного Названия");
        System.out.println("4) одну книгу по ID");
        System.out.println("5) все книги");
        System.out.println("6) Вернуться в главное меню");
        String num = scanner.nextLine();

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
                getOneBook(service);
                break;
            case "5":
                service.fetchAllBooks();
                break;
            case "6":
                break;
            default:
                System.out.println("Введите цифру которая соответствует нужному вам действию!");
                sortBooks(service);
        }

    }

    private static void addBook(BookService service) {
        if (yesNo()) {
            service.create();
        }
    }

    private static void redactor(BookService service) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ввидите id книги которую нужно отредактировать");
            System.out.print("ID : ");
            int idRedactor = scanner.nextInt();
            if (yesNo()) {
                service.update(idRedactor);
            }
        } catch (InputMismatchException e) {
            System.out.println("ID состоит из цифр");
            System.out.println("Попробуйте еще раз");
            redactor(service);
        }
    }

    private static void deleteBook(BookService service) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ID книги: ");
            int id = scanner.nextInt();
            if (yesNo()) {
                service.delete(id);
            }
        } catch (InputMismatchException e) {
            System.out.println("ID состоит из цифр");
            System.out.println("Попробуйте еще раз");
            deleteBook(service);
        }
    }

    private static void getOneBook(BookService service) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ID книги: ");
            int id = scanner.nextInt();
            if (yesNo()) {
                service.fetchBookByID(id);
            }
        } catch (InputMismatchException e) {
            System.out.println("ID состоит из цифр");
            System.out.println("Попробуйте еще раз");
            getOneBook(service);
        }
    }

    private static boolean yesNo() {
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Нажмите \"1\" чтобы продолжить");
        System.out.println("Нажмите \"2\" чтоб вернуться в главное меню");
        String num = scanner.nextLine();
        switch (num) {
            case "1":
                flag = true;
                break;
            case "2":
                flag = false;
                break;
            default:
                yesNo();
        }
        return flag;
    }
}

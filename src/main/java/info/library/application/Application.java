package info.library.application;

import info.library.service.ApplicationService;
import info.library.service.ApplicationServiceImpl;
import info.library.service.BookService;

import java.util.*;

public class Application {
    public static Scanner scanner = new Scanner(System.in);
    public static void start() {
        ApplicationService service = new ApplicationServiceImpl();
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите действие:");
            System.out.println("1) Вывод книг.");
            System.out.println("2) Добавление книги.");
            System.out.println("3) Удаление книги.");
            System.out.println("4) Редактирование книги.");
            System.out.println("5) Выход.");
            String num = scanner.nextLine();
            switch (num) {
                case "1":
                    service.sortBooks();
                    break;
                case "2":
                    service.addBook();
                    break;
                case "3":
                    service.deleteBook();
                    break;
                case "4":
                    service.redactor();
                    break;
                case "5":
                    scanner.close();
                    flag = false;
                    return;
                default:
                    System.out.println("Введите цифру которая соответствует нужному вам действию!");
            }
        }
    }
}

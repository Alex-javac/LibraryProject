package info.library.service;

import info.library.dao.BookDao;
import info.library.dao.BookDaoImpl;
import info.library.model.books.Book;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FillingDatabase {
    private static List<Path> paths = new ArrayList<>();

    public static void fillIn() throws IOException {
        BookDao bookDao = new BookDaoImpl();
        Files.walkFileTree(Paths.get("/home/alexander/IdeaProjects/LibraryProject/src/main/java/files"), new MyFileVisitor());
            paths.forEach(file -> {
                if (ValidationChecker.validateXMLSchema(file)) {
                    Book book = JaxbCreate.bookUnmarshalling(file);
                    try {
                        bookDao.create(book);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            if (path.toString().endsWith(".xml"))
                paths.add(path);
            return FileVisitResult.CONTINUE;
        }
    }
}

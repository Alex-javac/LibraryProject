package info.library.service;

import info.library.model.books.Book;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Path;

public class JaxbCreate {
   static JAXBContext context;
    static Unmarshaller unmarshaller;
    static {
        try {
            context = JAXBContext.newInstance(Book.class);
            unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public static Book bookUnmarshalling(Path file) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(file)));) {
            return (Book) unmarshaller.unmarshal(bufferedReader);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

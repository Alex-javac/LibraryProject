package info.library.service;

import info.library.model.books.Book;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Path;

public class JaxbCreate {

    public static Book bookUnmarshalling(Path file) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(file)));) {
            JAXBContext context = JAXBContext.newInstance(Book.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Book) unmarshaller.unmarshal(bufferedReader);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

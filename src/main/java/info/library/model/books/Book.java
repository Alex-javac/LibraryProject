package info.library.model.books;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Setter
@Getter
@NoArgsConstructor
@XmlRootElement
public class Book {
    //@XmlAttribute
    private int id;
    private Genre genre;
    private String title;
    private String author;
}

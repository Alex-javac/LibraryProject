package info.library.model.books;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "book")
public class Book {
    @XmlAttribute
    private int id;
    @XmlElement
    private Genre genre;
    @XmlElement
    private String title;
    @XmlElement
    private String author;
}

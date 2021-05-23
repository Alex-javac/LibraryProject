package info.library.service;


public interface BookService {

    void fetchBookByID(int id);

    void fetchBooksByGenre();

    void fetchBooksByTitle();

    void fetchBooksByAuthor();

    void fetchAllBooks();

    void delete(int id);

    void update(int id);

    void create();

}

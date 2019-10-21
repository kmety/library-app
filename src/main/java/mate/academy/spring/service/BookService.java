package mate.academy.spring.service;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.entity.Book;

public interface BookService {
    Book add(Book book);

    List<Book> getAll();

    Optional<Book> getById(Long id);

    List<Book> getByTitle(String title);

    void delete(Long id);

}

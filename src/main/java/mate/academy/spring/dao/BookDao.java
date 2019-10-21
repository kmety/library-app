package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.entity.Book;

public interface BookDao {
    Book add(Book book);

    Optional<Book> getById(Long id);

    List<Book> getByTitle(String title);

    void delete(Long id);

    List<Book> getAll();
}

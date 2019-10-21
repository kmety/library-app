package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.entity.Author;

public interface AuthorDao {
    Author add(Author author);

    Optional<Author> getById(Long id);

    List<Author> getAll();

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}

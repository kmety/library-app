package mate.academy.spring.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.dao.AuthorDao;
import mate.academy.spring.entity.Author;
import mate.academy.spring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    @Transactional
    public Author add(Author author) {
        return authorDao.add(author);
    }

    @Override
    @Transactional
    public Optional<Author> getById(Long id) {
        return authorDao.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> getAll() {
        return authorDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findByName(String name) {
        return authorDao.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findByNameAndSurname(String name, String surname) {
        return authorDao.findByNameAndSurname(name, surname);
    }
}

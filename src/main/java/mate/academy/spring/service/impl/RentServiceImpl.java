package mate.academy.spring.service.impl;

import java.util.List;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Override
    @Transactional
    public Rent rentBook(User user, Book book) {
        Rent rent = new Rent(user, book, true);
        return rentDao.rentBook(rent);
    }

    @Override
    @Transactional
    public void returnBook(User user, Book book) {
        rentDao.returnBook(user, book);
    }

    @Override
    @Transactional
    public boolean isRentedByUser(User user, Book book) {
        return rentDao.isRentedByUser(user, book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getBooksRentedByUser(User user) {
        return rentDao.getBooksRentedByUser(user);
    }
}

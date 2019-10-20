package mate.academy.spring.dao.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImpl implements RentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Rent rentBook(Rent rent) {
        Long id = (Long) sessionFactory.getCurrentSession().save(rent);
        rent.setId(id);
        return rent;
    }

    @Override
    public void returnBook(User user, Book book) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE user = :user AND book = :book", Rent.class);
        query.setParameter("user", user);
        query.setParameter("book", book);
        Rent rent = query.getSingleResult();
        rent.setActive(false);
        sessionFactory.getCurrentSession().update(rent);
    }

    @Override
    public List<Book> getBooksRentByUser(User user) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE user = :user AND active = true", Rent.class);
        query.setParameter("user", user);
        List<Rent> rents = query.getResultList();
        return rents.stream().map(Rent::getBook).collect(Collectors.toList());
    }
}

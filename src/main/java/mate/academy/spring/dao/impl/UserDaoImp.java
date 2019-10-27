package mate.academy.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.UserDao;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User add(User user) {
        System.out.println(user.getRoles());
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "FROM User WHERE username = :username", User.class);
        query.setParameter("username", username);
        Optional<User> optionalUser;
        try {
            optionalUser = Optional.of(query.getSingleResult());
        } catch (Exception e) {
            optionalUser = Optional.empty();
        }
        return optionalUser;
    }

    @Override
    public Optional<User> getByEmail(String email) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);
        Optional<User> optionalUser;
        try {
            optionalUser = Optional.of(query.getSingleResult());
        } catch (Exception e) {
            optionalUser = Optional.empty();
        }
        return optionalUser;
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(User.class, id));
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> query
                = sessionFactory.getCurrentSession().createQuery("FROM User", User.class);
        return query.getResultList();
    }
}

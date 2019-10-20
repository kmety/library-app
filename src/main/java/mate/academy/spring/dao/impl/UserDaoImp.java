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
        Long id = (Long) sessionFactory.getCurrentSession().save(user);
        user.setId(id);
        return user;
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

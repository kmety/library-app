package mate.academy.spring.service.impl;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.dao.UserDao;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Transactional
    @Override
    public Optional<User> getById(Long id) {
        return userDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

}

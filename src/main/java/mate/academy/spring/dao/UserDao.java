package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.User;

public interface UserDao {
    User add(User user);

    Optional<User> getById(Long id);

    List<User> getAll();
}

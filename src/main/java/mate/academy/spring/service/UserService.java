package mate.academy.spring.service;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.dto.UserRegistrationDto;
import mate.academy.spring.entity.User;

public interface UserService {
    User add(UserRegistrationDto userDto);

    Optional<User> getByUsername(String username);

    Optional<User> getById(Long id);

    List<User> getAll();
}

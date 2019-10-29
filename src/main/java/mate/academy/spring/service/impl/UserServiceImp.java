package mate.academy.spring.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.dao.UserDao;
import mate.academy.spring.dto.DtoUtil;
import mate.academy.spring.dto.UserRegistrationDto;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private DtoUtil dtoUtil;

    @Transactional
    @Override
    public User add(UserRegistrationDto userDto) throws IllegalArgumentException {
        if (emailExist(userDto.getEmail())) {
            throw new IllegalArgumentException(
                    "There is an account with that email adress: "
                            + userDto.getEmail());
        }
        if (usernameExist(userDto.getUserName())) {
            throw new IllegalArgumentException(
                    "There is an account with that username: "
                            + userDto.getUserName());
        }
        User user = dtoUtil.parse(userDto);
        return userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getByUserName(String username) {
        return userDao.getByUserName(username);
    }

    private boolean emailExist(String email) {
        Optional<User> userOptional = userDao.getByEmail(email);
        return userOptional.isPresent();
    }

    private boolean usernameExist(String username) {
        Optional<User> userOptional = userDao.getByUserName(username);
        return userOptional.isPresent();
    }

    @Transactional(readOnly = true)
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

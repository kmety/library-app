package mate.academy.spring.dto;

import mate.academy.spring.entity.Role;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DtoUtil {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User parse(UserRegistrationDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName());
        user.setSurname(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUserName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleService.getByName(userDto.getRole());
        user.getRoles().add(role);
        return user;
    }
}

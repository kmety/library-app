package mate.academy.spring.service;

import mate.academy.spring.entity.Role;

public interface RoleService {
    void addRole(String roleName);

    Role getByName(String roleName);
}

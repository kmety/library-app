package mate.academy.spring.dao;

import mate.academy.spring.entity.Role;

public interface RoleDao {
    void addRole(Role role);

    Role getByName(String roleName);
}

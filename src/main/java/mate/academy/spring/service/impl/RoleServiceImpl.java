package mate.academy.spring.service.impl;

import mate.academy.spring.dao.RoleDao;
import mate.academy.spring.entity.Role;
import mate.academy.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public void addRole(String roleName) {
        Role role = new Role();
        switch (roleName.toLowerCase()) {
            case ("user"):
                role.setRole("ROLE_USER");
                break;
            case ("admin"):
                role.setRole("ROLE_ADMIN");
                break;
            default:
                throw new IllegalArgumentException("Wrong role name");
        }
        roleDao.addRole(role);
    }

    @Transactional(readOnly = true)
    @Override
    public Role getByName(String roleName) {
        switch (roleName.toLowerCase()) {
            case ("user"):
                roleName = "ROLE_USER";
                break;
            case ("admin"):
                roleName = "ROLE_ADMIN";
                break;
            default:
                throw new IllegalArgumentException("Wrong role name");
        }
        return roleDao.getByName(roleName);
    }
}

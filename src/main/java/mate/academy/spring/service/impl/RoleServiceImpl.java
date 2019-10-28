package mate.academy.spring.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mate.academy.spring.dao.RoleDao;
import mate.academy.spring.entity.Role;
import mate.academy.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
    private static final List<String> ROLE_NAMES = new ArrayList<>(
            Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public void addRole(String roleName) {
        if (ROLE_NAMES.contains(roleName)) {
            roleDao.addRole(new Role(roleName));
        } else {
            throw new IllegalArgumentException("Wrong role name");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Role getByName(String roleName) {
        if (ROLE_NAMES.contains(roleName)) {
            return roleDao.getByName(roleName);
        } else {
            throw new IllegalArgumentException("Wrong role name");
        }
    }
}

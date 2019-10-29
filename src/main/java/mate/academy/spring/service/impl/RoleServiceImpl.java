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
        roleDao.addRole(new Role(roleName));
    }

    @Transactional(readOnly = true)
    @Override
    public Role getByName(String roleName) {
        return roleDao.getByName(roleName);
    }
}

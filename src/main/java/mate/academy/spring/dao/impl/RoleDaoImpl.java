package mate.academy.spring.dao.impl;

import javax.persistence.TypedQuery;
import mate.academy.spring.dao.RoleDao;
import mate.academy.spring.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public Role getByName(String roleName) {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Role WHERE roleName = :roleName", Role.class);
        query.setParameter("roleName", roleName);
        return query.getSingleResult();
    }
}

package by.pvt.repository;


import by.pvt.pojo.user.AppUser;
import by.pvt.pojo.user.AppUserRole;
import by.pvt.pojo.user.RoleName;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class UserRoleRepository {

    private static Logger log = Logger.getLogger("UserRoleRepository.class");

    @Autowired
    private SessionFactory sessionFactory;

    public void save(AppUserRole userRole){
        sessionFactory.getCurrentSession().save(userRole);
    }

    public AppUserRole findRoleByName(RoleName roleName){
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from AppUserRole where roleName like:param1", AppUserRole.class)
                    .setParameter("param1", roleName)
                    .getSingleResult();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }
}
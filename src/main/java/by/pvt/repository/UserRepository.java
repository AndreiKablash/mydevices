package by.pvt.repository;


import by.pvt.pojo.user.AppUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class UserRepository {

    private static Logger log = Logger.getLogger("UserRepository.class");

    @Autowired
    SessionFactory sessionFactory;

    public AppUser findById(Long id){
        return sessionFactory.getCurrentSession()
                .get(AppUser.class, id);
    }

    public AppUser findUserByLogin(String login){
        try{
            return sessionFactory.getCurrentSession().createQuery("from AppUser where login like:param1",AppUser.class)
                    .setParameter("param1", login)
                    .getSingleResult();
        }catch(Exception e){
            log.warning(e.getMessage());
            return null;
        }
    }

    public AppUser findUserByEmail(String email){
        try{
            return sessionFactory.getCurrentSession().createQuery("from AppUser where email like:param1",AppUser.class)
                    .setParameter("param1", email)
                    .getSingleResult();
        }catch(Exception e){
            log.warning(e.getMessage());
            return null;
        }
    }

    public boolean add(AppUser user) {
        sessionFactory.getCurrentSession()
                .persist(user);
        return true;
    }

    public boolean delete(AppUser user){
        sessionFactory.getCurrentSession().delete(user);
        return true;
    }
}

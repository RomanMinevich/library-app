package mate.academy.spring.dao.impl;

import java.util.List;
import mate.academy.spring.dao.UserDao;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User get(Long id) {
        return sessionFactory.getCurrentSession()
                .get(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User", User.class)
                .getResultList();
    }
}

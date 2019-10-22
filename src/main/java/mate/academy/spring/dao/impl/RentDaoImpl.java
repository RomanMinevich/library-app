package mate.academy.spring.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImpl implements RentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Rent rent) {
        sessionFactory.getCurrentSession().save(rent);
    }

    @Override
    public void returnBook(User user, Book book) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Rent set active = false where user = :user and book = :book");
        query.setParameter("user", user);
        query.setParameter("book", book);
        query.executeUpdate();
    }

    @Override
    public List<Rent> getByUser(User user) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("from Rent where user = :user", Rent.class);
        query.setParameter("user", user);
        return query.getResultList();
    }
}

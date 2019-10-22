package mate.academy.spring.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public Rent returnBook(User user, Book book) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Rent> query = session.createQuery(
                        "from Rent where user = :user and book = :book", Rent.class);
        query.setParameter("user", user);
        query.setParameter("book", book);
        Rent rent = query.getSingleResult();
        rent.setActive(false);
        session.update(rent);
        return rent;
    }

    @Override
    public List<Rent> getByUser(User user) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("from Rent where user = :user", Rent.class);
        query.setParameter("user", user);
        return query.getResultList();
    }
}

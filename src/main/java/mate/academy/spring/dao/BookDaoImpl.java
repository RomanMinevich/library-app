package mate.academy.spring.dao;

import java.util.List;
import mate.academy.spring.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public List<Book> listBooks() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Book", Book.class)
                .getResultList();
    }
}

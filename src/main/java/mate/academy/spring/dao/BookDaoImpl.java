package mate.academy.spring.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import mate.academy.spring.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private static SessionFactory sessionFactory;

    @Override
    public Book add(Book book) {
        sessionFactory.getCurrentSession().save(book);
        return book;
    }

    @Override
    public List<Book> findByTitle(String title) {
        @SuppressWarnings("unchecked")
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("from Book where title = :title");
        query.setParameter("title", title);
        return query.getResultList();
    }
}

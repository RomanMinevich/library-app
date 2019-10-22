package mate.academy.spring.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.AuthorDao;
import mate.academy.spring.entity.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImpl implements AuthorDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

    @Override
    public List<Author> findByName(String firstName, String lastName) {
        TypedQuery<Author> query = sessionFactory.getCurrentSession()
                .createQuery("from Author where firstName like :firstName "
                        + "and lastName like :lastName", Author.class);
        query.setParameter("firstName", "%" + firstName + "%");
        query.setParameter("lastName", "%" + lastName + "%");
        return query.getResultList();
    }
}

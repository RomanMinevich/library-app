package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.dao.BookDao;
import mate.academy.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.findByTitle(title);
    }
}

package mate.academy.spring.service.impl;

import java.util.List;
import mate.academy.spring.dao.BookDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public Book add(Book book) {
        bookDao.add(book);
        return book;
    }

    @Transactional(readOnly = true)
    @Override
    public Book get(Long id) {
        return bookDao.get(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.findByTitle(title);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }
}

package mate.academy.spring.dao;

import java.util.List;
import mate.academy.spring.entity.Book;

public interface BookDao {

    void add(Book book);

    Book get(Long id);

    List<Book> findByTitle(String title);

    List<Book> listBooks();
}

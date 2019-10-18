package mate.academy.spring.dao;

import java.util.List;
import mate.academy.spring.entity.Book;

public interface BookDao {

    Book add(Book book);

    List<Book> findByTitle(String title);
}

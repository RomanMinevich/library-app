package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.entity.Book;

public interface BookService {

    Book add(Book book);

    Book get(Long id);

    List<Book> findByTitle(String title);

    List<Book> listBooks();
}

package mate.academy.spring.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    private RentDao libraryDao;

    @Transactional
    @Override
    public Rent rentBook(User user, Book book) {
        Rent rent = new Rent(user, book);
        libraryDao.add(rent);
        return rent;
    }

    @Transactional
    @Override
    public void returnBook(User user, Book book) {
        libraryDao.returnBook(user, book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksRentByUser(User user) {
        return libraryDao.getByUser(user)
                .stream()
                .map(Rent::getBook)
                .collect(Collectors.toList());
    }
}

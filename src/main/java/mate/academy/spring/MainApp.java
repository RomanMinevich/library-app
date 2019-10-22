package mate.academy.spring;

import java.sql.SQLException;
import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Sunil", "Bora", "suni.bora@example.com");
        userService.add(user1);
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        for (User user : userService.listUsers()) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        BookService bookService = context.getBean(BookService.class);

        Book book1 = new Book("Hamlet", 2000, 35D);
        bookService.add(book1);
        Book book2 = new Book("King Lear", 1965, 22D);
        bookService.add(book2);
        bookService.add(new Book("Macbeth", 2017, 110D));

        for (Book book : bookService.findByTitle("King")) {
            System.out.println("Id = " + book.getId());
            System.out.println("Title = " + book.getTitle());
            System.out.println("Year = " + book.getYear());
            System.out.println("Price = " + book.getPrice());
            System.out.println();
        }

        AuthorService authorService = context.getBean(AuthorService.class);

        authorService.add(new Author("William", "Shakespeare"));
        authorService.add(new Author("James", "Joyce"));

        for (Author author: authorService.findByNameAndSurname(
                "William", "Shakespeare")) {
            System.out.println("Id = " + author.getId());
            System.out.println();
        }

        RentService rentService = context.getBean(RentService.class);

        rentService.rentBook(user1, book1);
        rentService.rentBook(user1, book2);

        rentService.returnBook(user1, book1);

        for (Book book : rentService.getBooksRentByUser(user1)) {
            System.out.println("Id = " + book.getId());
            System.out.println("Title = " + book.getTitle());
            System.out.println("Year = " + book.getYear());
            System.out.println("Price = " + book.getPrice());
            System.out.println();
        }

        context.close();
    }
}

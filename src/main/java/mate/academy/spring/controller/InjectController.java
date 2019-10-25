package mate.academy.spring.controller;

import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inject")
public class InjectController {

    @GetMapping
    public String inject() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Sunil", "Bora", "suni.bora@example.com");
        userService.add(user1);
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        BookService bookService = context.getBean(BookService.class);

        Book book1 = new Book("Hamlet", 2000, 35D);
        bookService.add(book1);
        Book book2 = new Book("King Lear", 1965, 22D);
        bookService.add(book2);
        bookService.add(new Book("Macbeth", 2017, 110D));

        AuthorService authorService = context.getBean(AuthorService.class);

        authorService.add(new Author("William", "Shakespeare"));
        authorService.add(new Author("James", "Joyce"));

        return "allBooks";
    }
}

package mate.academy.spring.controller;

import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    private static final Long USER_ID = 1L;
    @Autowired
    private RentService rentService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public String rentBook(@RequestParam("bookId") Long bookId) {
        rentService.rentBook(
                userService.get(USER_ID), bookService.get(bookId));
        return "allBooks";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam("bookId") Long bookId) {
        rentService.returnBook(
                userService.get(USER_ID), bookService.get(bookId));
        return "allBooks";
    }

    @GetMapping("/user")
    public String rentBooks(ModelMap model) {
        model.put("rentByUser",
                rentService.getBooksRentByUser(userService.get(USER_ID)));
        return "rentInfo";
    }
}

package mate.academy.spring.controller;

import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(ModelMap model) {
        model.put("books", bookService.listBooks());
        return "allBooks";
    }

    @GetMapping("/{id}")
    public String getBookInfo(
            ModelMap model, @PathVariable("id") Long id) {
        model.put("book", bookService.get(id));
        return "bookInfo";
    }

    @GetMapping("/find")
    public String findBooksByTitle(
            @RequestParam("title") String title, ModelMap model) {
        model.put("books", bookService.findByTitle(title));
        return "allBooks";
    }

    @GetMapping("/add")
    public String addBookPage() {
        return "addBooks";
    }

    @PostMapping("/add")
    public String addBook(
            @ModelAttribute Book book, ModelMap model) {
        bookService.add(book);
        return getAllBooks(model);
    }
}

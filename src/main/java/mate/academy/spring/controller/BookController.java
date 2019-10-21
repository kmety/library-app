package mate.academy.spring.controller;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public String getAllBooks(ModelMap model) {
        List<Book> books = bookService.getAll();
        model.put("books", books);
        return "books";
    }

    @GetMapping("/info")
    public String bookInfo(@RequestParam("book_id") Long id, Model model) {
        Optional<Book> bookOptional = bookService.getById(id);
        if (bookOptional.isEmpty()) {
            model.addAttribute("message", "Book not found");
            return "errorPage";
        }
        model.addAttribute("book", bookOptional.get());
        return "bookInfo";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("book_id") Long id) {
        bookService.delete(id);
        return "forward:/book/all";
    }
}

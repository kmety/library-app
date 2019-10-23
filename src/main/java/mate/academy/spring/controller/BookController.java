package mate.academy.spring.controller;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("bookForm", new Book());
        return "createBook";
    }

    @PostMapping("/add")
    public String addBook(
            @ModelAttribute("bookForm") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("message", "Book creating error");
            return "errorPage";
        }
        bookService.add(book);
        return getAllBooks(model);
    }

    @GetMapping("/{id}")
    public String bookInfo(@PathVariable("id") Long id, Model model) {
        Optional<Book> bookOptional = bookService.getById(id);
        if (bookOptional.isEmpty()) {
            model.addAttribute("message", "Book not found");
            return "errorPage";
        }
        model.addAttribute("book", bookOptional.get());
        return "bookInfo";
    }

    @GetMapping("/find")
    public String findByTitle(@RequestParam("title") String title, Model model) {
        List<Book> books = bookService.getByTitle(title);
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("book_id") Long id) {
        bookService.delete(id);
        return "forward:/book/all";
    }
}

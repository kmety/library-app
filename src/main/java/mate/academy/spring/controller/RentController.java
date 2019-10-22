package mate.academy.spring.controller;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    private static final Long USER_ID = 1L;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private RentService rentService;

    @GetMapping("/getBook")
    public String rentBook(@RequestParam("book_id") Long bookId, Model model) {
        Optional<User> optionalUser = userService.getById(USER_ID);
        if (optionalUser.isEmpty()) {
            model.addAttribute("message", "User not found");
            return "errorPage";
        }
        Optional<Book> optionalBook = bookService.getById(bookId);
        if (optionalBook.isEmpty()) {
            model.addAttribute("message", "Book not found");
            return "errorPage";
        }
        rentService.rentBook(optionalUser.get(), optionalBook.get());
        return "forward:/book/all";
    }

    @GetMapping("/returnBook")
    public String returnBook(@RequestParam("book_id") Long bookId, Model model) {
        Optional<User> optionalUser = userService.getById(USER_ID);
        if (optionalUser.isEmpty()) {
            model.addAttribute("message", "User not found");
            return "errorPage";
        }
        Optional<Book> optionalBook = bookService.getById(bookId);
        if (optionalBook.isEmpty()) {
            model.addAttribute("message", "Book not found");
            return "errorPage";
        }
        rentService.returnBook(optionalUser.get(), optionalBook.get());
        return "forward:/book/all";
    }

    @GetMapping("/rentedBooks")
    public String getBooksRentedByUser(Model model) {
        Optional<User> optionalUser = userService.getById(USER_ID);
        if (optionalUser.isEmpty()) {
            model.addAttribute("message", "User not found");
            return "errorPage";
        }
        List<Book> books = rentService.getBooksRentedByUser(optionalUser.get());
        model.addAttribute("books", books);
        return "books";
    }
}

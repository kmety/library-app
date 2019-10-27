package mate.academy.spring.controller;

import java.security.Principal;
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
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private RentService rentService;

    @GetMapping("/rentBook")
    public String rentBook(@RequestParam("book_id") Long bookId, Model model, Principal principal) {
        Optional<User> optionalUser = getCurrentUser(principal);
        if (optionalUser.isEmpty()) {
            model.addAttribute("message", "User not found");
            return "errorPage";
        }
        Optional<Book> optionalBook = bookService.getById(bookId);
        if (optionalBook.isEmpty()) {
            model.addAttribute("message", "Book not found");
            return "errorPage";
        }
        if (!(rentService.isRentedByUser(optionalUser.get(), optionalBook.get()))) {
            rentService.rentBook(optionalUser.get(), optionalBook.get());
            return "forward:/book/all";
        }
        model.addAttribute("message", "Book " + optionalBook.get().getTitle()
                + " has already been rented by user "
                + optionalUser.get().getUsername());
        return "errorPage";
    }

    @GetMapping("/returnBook")
    public String returnBook(
            @RequestParam("book_id") Long bookId, Model model, Principal principal) {
        Optional<User> optionalUser = getCurrentUser(principal);
        if (optionalUser.isEmpty()) {
            model.addAttribute("message", "User not found");
            return "errorPage";
        }
        Optional<Book> optionalBook = bookService.getById(bookId);
        if (optionalBook.isEmpty()) {
            model.addAttribute("message", "Book not found");
            return "errorPage";
        }
        if (rentService.isRentedByUser(optionalUser.get(), optionalBook.get())) {
            rentService.returnBook(optionalUser.get(), optionalBook.get());
            return getBooksRentedByUser(model, principal);
        }
        model.addAttribute("message", "Book " + optionalBook.get().getTitle()
                + " was not rented by user "
                + optionalUser.get().getUsername());
        return "errorPage";
    }

    @GetMapping("/rentedBooks")
    public String getBooksRentedByUser(Model model, Principal principal) {
        Optional<User> optionalUser = getCurrentUser(principal);
        if (optionalUser.isEmpty()) {
            model.addAttribute("message", "User not found");
            return "errorPage";
        }
        List<Book> books = rentService.getBooksRentedByUser(optionalUser.get());
        model.addAttribute("books", books);
        return "rentedBooks";
    }

    private Optional<User> getCurrentUser(Principal principal) {
        if (principal == null) {
            return Optional.empty();
        }
        return userService.getByUsername(principal.getName());
    }
}

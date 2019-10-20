package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;

public interface RentService {
    Rent rentBook(User user, Book book);

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);
}

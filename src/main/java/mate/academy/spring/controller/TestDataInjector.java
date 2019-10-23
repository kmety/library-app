package mate.academy.spring.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDataInjector {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private UserService userService;

    @PostConstruct
    public void injectData() {
        Book book1 = new Book("book1", 2011, 100.);
        List<Author> book1Authors = new ArrayList<>();
        Author author1 = authorService.add(new Author("authorName1", "authorSurname1"));
        book1Authors.add(author1);
        Author author2 = authorService.add(new Author("authorName2", "authorSurname2"));
        book1Authors.add(author2);
        book1.setAuthors(book1Authors);
        bookService.add(book1);

        Book book2 = new Book("book2", 2012, 200.);
        List<Author> book2Authors = new ArrayList<>();
        Author author3 = authorService.add(new Author("authorName3", "authorSurname3"));
        book2Authors.add(author3);
        book2.setAuthors(book2Authors);
        bookService.add(book2);

        Book book3 = new Book("book3", 2013, 300.);
        List<Author> book3Authors = new ArrayList<>();
        book3Authors.add(author1);
        book3Authors.add(author3);
        book3.setAuthors(book3Authors);
        bookService.add(book3);

        Book book4 = new Book("book4", 2014, 400.);
        List<Author> book4Authors = new ArrayList<>();
        Author author4 = authorService.add(new Author("authorName4", "authorSurname4"));
        book4Authors.add(author4);
        Author author5 = authorService.add(new Author("authorName5", "authorSurname5"));
        book4Authors.add(author5);
        book4.setAuthors(book4Authors);
        bookService.add(book4);

        User user1 = new User("Ivan", "Ivanov");
        userService.add(user1);
        User user2 = new User("Peter", "Petrov");
        userService.add(user2);
        User user3 = new User("Nikolay", "Nikolaev");
        userService.add(user3);
    }
}

package mate.academy.spring.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import mate.academy.spring.dto.UserRegistrationDto;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RoleService;
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
    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void injectData() {
        Book book1 = new Book("Where the Crawdads Sing", 2018, 14.29);
        List<Author> book1Authors = new ArrayList<>();
        Author author1 = authorService.add(new Author("Delia", "Owens"));
        book1Authors.add(author1);
        Author author2 = authorService.add(new Author("Rachel", "Hollis"));
        book1Authors.add(author2);
        book1.setAuthors(book1Authors);
        bookService.add(book1);

        Book book2 = new Book("Educated: A Memoir", 2019, 13.99);
        List<Author> book2Authors = new ArrayList<>();
        Author author3 = authorService.add(new Author("Tara", "Westover"));
        book2Authors.add(author3);
        book2.setAuthors(book2Authors);
        bookService.add(book2);

        Book book3 = new Book("Becoming", 2019, 16.29);
        List<Author> book3Authors = new ArrayList<>();
        book3Authors.add(author1);
        book3Authors.add(author3);
        book3.setAuthors(book3Authors);
        bookService.add(book3);

        Book book4 = new Book("The Wonderful Things You Will Be", 2019, 10.29);
        List<Author> book4Authors = new ArrayList<>();
        Author author4 = authorService.add(new Author("Emily", "Martin"));
        book4Authors.add(author4);
        Author author5 = authorService.add(new Author("Mark", "Levin"));
        book4Authors.add(author5);
        book4.setAuthors(book4Authors);
        bookService.add(book4);

        roleService.addRole("ROLE_USER");
        roleService.addRole("ROLE_ADMIN");

        UserRegistrationDto ivan = new UserRegistrationDto();
        ivan.setFirstName("Ivanov");
        ivan.setLastName("Ivan");
        ivan.setEmail("ivan@gmail.com");
        ivan.setUserName("ivan");
        ivan.setPassword("1");
        ivan.setRepeatPassword("1");
        ivan.setRole("ROLE_ADMIN");
        userService.add(ivan);

        UserRegistrationDto peter = new UserRegistrationDto();
        peter.setFirstName("Peterson");
        peter.setLastName("Peters");
        peter.setEmail("peter@gmail.com");
        peter.setUserName("peter");
        peter.setPassword("1");
        peter.setRepeatPassword("1");
        userService.add(peter);

        UserRegistrationDto nick = new UserRegistrationDto();
        nick.setFirstName("Nickolson");
        nick.setLastName("Nick");
        nick.setEmail("nick@gmail.com");
        nick.setUserName("nick");
        nick.setPassword("1");
        nick.setRepeatPassword("1");
        userService.add(nick);
    }
}

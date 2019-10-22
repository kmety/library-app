package mate.academy.spring;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        final UserService userService = context.getBean(UserService.class);
        final BookService bookService = context.getBean(BookService.class);
        final AuthorService authorService = context.getBean(AuthorService.class);
        final RentService rentService = context.getBean(RentService.class);

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

        // Get Books
        List<Book> books = bookService.getAll();
        books.forEach(System.out::println);
        System.out.println();

        // Get Authors
        List<Author> authors = authorService.getAll();
        authors.forEach(System.out::println);
        System.out.println();

        // Find author by name
        List<Author> authorsByName = authorService.findByName("authorName3");
        authorsByName.forEach(System.out::println);
        System.out.println();

        // Find author by name and surname
        List<Author> authorsByNameAndSurname
                = authorService.findByNameAndSurname("authorName4", "authorSurname4");
        authorsByNameAndSurname.forEach(System.out::println);
        System.out.println();

        // Find book by title
        List<Book> booksByTitle = bookService.getByTitle("book3");
        booksByTitle.forEach(System.out::println);
        System.out.println();

        // Renting books
        User user1 = userService.add(new User("Sunil", "Bora"));
        rentService.rentBook(user1, book1);
        User user2 = userService.add(new User("David", "Miller"));
        rentService.rentBook(user2, book2);
        User user3 = userService.add(new User("Sameer", "Singh"));
        rentService.rentBook(user3, book3);
        rentService.rentBook(user3, book4);

        // Get Users
        List<User> users = userService.getAll();
        users.forEach(System.out::println);
        System.out.println();

        // Get rented books
        List<Book> rentedBooks = rentService.getBooksRentedByUser(user3);
        rentedBooks.forEach(System.out::println);
        System.out.println();

        // Return book
        rentService.returnBook(user3, book3);
        rentedBooks = rentService.getBooksRentedByUser(user3);
        rentedBooks.forEach(System.out::println);
        context.close();
    }
}

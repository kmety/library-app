package mate.academy.spring.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "books_authors",
            joinColumns = {@JoinColumn(
                    name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id", referencedColumnName = "author_id")})
    private List<Author> authors = new ArrayList<>();

    private Integer year;
    private Double price;

    public Book() {
    }

    public Book(String title, Integer year, Double price) {
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        String bookInfo = "Book: id" + id + " " + title + " " + year + " " + price + " authors: ";
        String authorsInfo = this.authors
                .stream()
                .map(Author::getSurname)
                .collect(Collectors.joining(", "));
        return bookInfo + authorsInfo;
    }
}

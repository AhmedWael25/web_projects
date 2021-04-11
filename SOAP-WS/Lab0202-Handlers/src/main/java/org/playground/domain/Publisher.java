package org.playground.domain;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "publisher")
@Table(name = "publisher", catalog = "webservicedb" , schema = "webservicedb")
public class Publisher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

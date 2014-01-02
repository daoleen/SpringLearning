package com.daoleen.springlearning.hibernate.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 2:41 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "Author")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    // Отношение "Один-ко-многим"
    // mappedBy - связано с определением внешнего ключа в таблице Telephone
    // cascade - операция обновления должна распространяться на дочерние записи
    // orphanRemove - значит, если автор удален - удалить и телефоны
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Telephone> telephones = new HashSet<Telephone>();


    // Отношение "Многие-ко-многим"
    // В @JoinTable указываем вспомогательную таблицу-связку:
    //      - joinColumns - в @JoinColumn указывается внешний ключ в ref-таблице на данную таблицу
    //      - inverseJoinColumns - в @JoinColumn указывается внешний ключ в ref-таблице на таблицу, с которой хотим соединиться
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "BOOK_AUTHOR_REF",
            joinColumns = @JoinColumn(name = "AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID")
    )
    private Set<Book> books = new HashSet<Book>();


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(Set<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

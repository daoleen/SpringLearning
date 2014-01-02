package com.daoleen.springlearning.hibernate;

import com.daoleen.springlearning.hibernate.domain.Author;
import com.daoleen.springlearning.hibernate.domain.Book;
import com.daoleen.springlearning.hibernate.domain.Telephone;
import com.daoleen.springlearning.hibernate.repository.IAuthorRepository;
import com.daoleen.springlearning.hibernate.repository.IBookRepository;
import com.daoleen.springlearning.hibernate.repository.ITelephoneRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 1:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private static ApplicationContext context = new GenericXmlApplicationContext("app-context.xml");

    public static void main(String[] args) {
        info();
        create();
        update();
        delete();
        info();
    }

    public static void info() {
        IBookRepository bookRepository = context.getBean("bookDao", IBookRepository.class);
        List<Book> books = bookRepository.findAll();

        System.out.println("List of books: ");
        for(Book book : books) {
            System.out.println(book);
            System.out.println("Authors of book: ");
            for(Author author : book.getAuthors()) {
                System.out.println(author);
            }
        }


        IAuthorRepository authorRepository = context.getBean("authorDao", IAuthorRepository.class);
        List<Author> authors = authorRepository.findAll();

        System.out.println("\n\nList of authors: ");
        for(Author author : authors) {
            System.out.println(author);

            System.out.println("Telephones:");
            for(Telephone t : author.getTelephones()) {
                System.out.println(t);
            }

            System.out.println("Books of this author: ");
            for(Book b : author.getBooks()) {
                System.out.println(b);
            }
        }


        ITelephoneRepository telephoneRepository = context.getBean("telephoneDao", ITelephoneRepository.class);
        List<Telephone> telephones = telephoneRepository.findAll();

        System.out.println("\nList of telephones: ");
        for(Telephone t : telephones) {
            System.out.println(t);
        }
    }

    public static void create() {
        Author author = new Author();
        author.setFirstName("Nikolay");
        author.setLastName("Morozov");

        IAuthorRepository authorRepository = context.getBean("authorDao", IAuthorRepository.class);
        authorRepository.save(author);
    }

    public static void update() {
        IAuthorRepository authorDao = context.getBean("authorDao", IAuthorRepository.class);
        Author author = authorDao.findById(2L);
        System.out.println("Changing author: " + author);
        author.setLastName("FrontDoor");
        authorDao.save(author);
    }

    public static void delete() {
        IAuthorRepository authorDao = context.getBean("authorDao", IAuthorRepository.class);
        Author author = authorDao.findById(3L);
        authorDao.delete(author);
    }
}

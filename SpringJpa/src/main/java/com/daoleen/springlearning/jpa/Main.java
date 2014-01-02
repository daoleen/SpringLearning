package com.daoleen.springlearning.jpa;

import com.daoleen.springlearning.jpa.domain.Author;
import com.daoleen.springlearning.jpa.domain.Book;
import com.daoleen.springlearning.jpa.domain.Telephone;
import com.daoleen.springlearning.jpa.service.IAuthorService;
import com.daoleen.springlearning.jpa.service.IBookService;
import com.daoleen.springlearning.jpa.service.ITelephoneService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 9:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
//    public static ApplicationContext context = new GenericXmlApplicationContext("app-context.xml");
//
//    public static void main(String[] args) {
//        ITelephoneService telephoneService = context.getBean("telephoneService", ITelephoneService.class);
//        List<Telephone> telephones = telephoneService.findAll();
//
//        for(Telephone telephone : telephones) {
//            System.out.println(telephone);
//        }
//
//
//        System.out.println("Finding by authorId: ");
//        List<Telephone> authorTelephones = telephoneService.findByAuthorId(2L);
//
//        for(Telephone telephone : authorTelephones) {
//            System.out.println(telephone);
//        }
//
//        System.out.println("Finding by authorId using JPQL: ");
//        List<Telephone> authorJpqlTelephones = telephoneService.findByAuthorIdUsingJpql(2L);
//
//        for(Telephone telephone : authorJpqlTelephones) {
//            System.out.println(telephone);
//        }
//    }


    private static ApplicationContext context = new GenericXmlApplicationContext("app-context.xml");

    public static void main(String[] args) {
        info();
//        create();
//        update();
//        delete();
//        info();
    }

    public static void info() {
        IBookService bookRepository = context.getBean("bookService", IBookService.class);
        List<Book> books = bookRepository.findAll();

        System.out.println("List of books: ");
        for(Book book : books) {
            System.out.println(book);
            System.out.print("Count of authors for this book: ");
            System.out.println(book.getAuthors().size());
            System.out.println("Authors of book: ");
            for(Author author : book.getAuthors()) {
                System.out.println(author);
            }
        }


        IAuthorService authorRepository = context.getBean("authorService", IAuthorService.class);
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


        ITelephoneService telephoneRepository = context.getBean("telephoneService", ITelephoneService.class);
        List<Telephone> telephones = telephoneRepository.findAll();

        System.out.println("\nList of telephones: ");
        for(Telephone t : telephones) {
            System.out.println(t);
        }
    }

//    public static void create() {
//        Author author = new Author();
//        author.setFirstName("Nikolay");
//        author.setLastName("Morozov");
//
//        IAuthorService authorRepository = context.getBean("authorService", IAuthorService.class);
//        authorRepository.save(author);
//    }
//
//    public static void update() {
//        IAuthorService authorDao = context.getBean("authorService", IAuthorService.class);
//        Author author = authorDao.findById(2L);
//        System.out.println("Changing author: " + author);
//        author.setLastName("FrontDoor");
//        authorDao.save(author);
//    }
//
//    public static void delete() {
//        IAuthorService authorDao = context.getBean("authorService", IAuthorService.class);
//        Author author = authorDao.findById(3L);
//        authorDao.delete(author);
//    }
}

package com.daoleen.springlearning.transaction;

import com.daoleen.springlearning.transaction.domain.Book;
import com.daoleen.springlearning.transaction.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by alex on 1/2/14.
 */
public class Main {
    private static ApplicationContext context = new GenericXmlApplicationContext("app-context.xml");

    public static void main(String[] args) {
        //findAll();
        //save();
        count();
    }

    private static void findAll() {
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Book> all = bookService.findAll();

        for(Book book : all) {
            System.out.println(book);
        }
    }

    private static void save() {
        BookService service = context.getBean("bookService", BookService.class);
        Book book = service.findById(2L);
        book.setName("Deprecated book");
        service.save(book);
        System.out.println("A book was saved successfully!");
    }

    private static void count() {
        BookService service = context.getBean("bookService", BookService.class);
        long count = service.countAll();
        System.out.println("Count of all books in library is: " + count);
    }
}

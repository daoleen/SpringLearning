package com.daoleen.springlearning.transaction.service.implementation;

import com.daoleen.springlearning.transaction.domain.Book;
import com.daoleen.springlearning.transaction.repository.BookRepository;
import com.daoleen.springlearning.transaction.service.BookService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alex on 1/2/14.
 */

@Service("bookService")
@Repository
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override   // no transactional was override!
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)   /// ! без транзакций !
    public long countAll() {
        return bookRepository.countAllBooks();
    }
}

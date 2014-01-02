package com.daoleen.springlearning.transaction.service;

import com.daoleen.springlearning.transaction.domain.Book;

import java.util.List;

/**
 * Created by alex on 1/2/14.
 */
public interface BookService {
    public List<Book> findAll();
    public Book findById(Long id);
    public Book save(Book book);
    public long countAll();
}

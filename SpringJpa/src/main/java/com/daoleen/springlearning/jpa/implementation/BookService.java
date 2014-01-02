package com.daoleen.springlearning.jpa.implementation;

import com.daoleen.springlearning.jpa.domain.Book;
import com.daoleen.springlearning.jpa.repository.IBookRepository;
import com.daoleen.springlearning.jpa.service.IBookService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 1/1/14
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */

@Service("bookService")
@Repository
@Transactional
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }
}

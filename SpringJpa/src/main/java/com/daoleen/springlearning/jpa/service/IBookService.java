package com.daoleen.springlearning.jpa.service;

import com.daoleen.springlearning.jpa.domain.Book;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 1/1/14
 * Time: 6:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IBookService {
    public List<Book> findAll();
}

package com.daoleen.springlearning.hibernate.repository;

import com.daoleen.springlearning.hibernate.domain.Book;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 1:11 AM
 * To change this template use File | Settings | File Templates.
 */

public interface IBookRepository {
    public List<Book> findAll();
}

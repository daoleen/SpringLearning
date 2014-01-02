package com.daoleen.springlearning.hibernate.repository;


import com.daoleen.springlearning.hibernate.domain.Author;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 2:47 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IAuthorRepository {
    public List<Author> findAll();
    public Author findById(Long id);
    public void save(Author author);    // create & update
    public void delete(Author author);
}

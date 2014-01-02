package com.daoleen.springlearning.jpa.service;

import com.daoleen.springlearning.jpa.domain.Author;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 1/1/14
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IAuthorService {
    public List<Author> findAll();
    public Author findById(Long id);
}

package com.daoleen.springlearning.jpa.service;

import com.daoleen.springlearning.jpa.domain.Telephone;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ITelephoneService {
    public List<Telephone> findAll();
    public List<Telephone> findByAuthorId(Long id);
    public List<Telephone> findByAuthorIdUsingJpql(Long id);
}

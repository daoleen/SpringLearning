package com.daoleen.springlearning.hibernate.repository;


import com.daoleen.springlearning.hibernate.domain.Telephone;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 3:18 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ITelephoneRepository {
    public List<Telephone> findAll();
}

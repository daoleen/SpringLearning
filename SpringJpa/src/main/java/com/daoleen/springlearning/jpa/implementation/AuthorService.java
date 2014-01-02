package com.daoleen.springlearning.jpa.implementation;

import com.daoleen.springlearning.jpa.domain.Author;
import com.daoleen.springlearning.jpa.repository.IAuthorRepository;
import com.daoleen.springlearning.jpa.service.IAuthorService;
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
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */

@Service("authorService")
@Repository
@Transactional
public class AuthorService implements IAuthorService {

    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return Lists.newArrayList(authorRepository.findAll());
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id);
    }
}

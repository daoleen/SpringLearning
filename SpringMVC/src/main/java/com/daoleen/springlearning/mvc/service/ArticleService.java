package com.daoleen.springlearning.mvc.service;

import com.daoleen.springlearning.mvc.domain.Article;

import java.util.List;

/**
 * Created by alex on 1/3/14.
 */
public interface ArticleService {
    public List<Article> findAll();
}

package com.daoleen.springlearning.mvc.service;

import com.daoleen.springlearning.mvc.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by alex on 1/3/14.
 */
public interface ArticleService {
    public List<Article> findAll();
    public Article findById(Long id);
    public Article save(Article article);
    public Page<Article> findAllOnPage(Pageable pageable);
}

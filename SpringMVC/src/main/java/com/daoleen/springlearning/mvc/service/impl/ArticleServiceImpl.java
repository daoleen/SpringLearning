package com.daoleen.springlearning.mvc.service.impl;

import com.daoleen.springlearning.mvc.domain.Article;
import com.daoleen.springlearning.mvc.repository.ArticleRepository;
import com.daoleen.springlearning.mvc.service.ArticleService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by alex on 1/3/14.
 */

@Service("articleService")
@Repository
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Article> findAll() {
        return Lists.newArrayList(articleRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Article findById(Long id) {
        return articleRepository.findOne(id);
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }


    // Получаем записи по страницам
    // В репозитории нужно изменить базовый класс
    // с CrudRepository<T,Ser..> на PagingAndSortingRepository<T,Ser..>
    @Override
    @Transactional(readOnly = true)
    public Page<Article> findAllOnPage(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }
}

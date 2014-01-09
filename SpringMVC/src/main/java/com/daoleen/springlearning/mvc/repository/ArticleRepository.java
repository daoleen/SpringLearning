package com.daoleen.springlearning.mvc.repository;

import com.daoleen.springlearning.mvc.domain.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by alex on 1/3/14.
 */
public interface ArticleRepository
    extends PagingAndSortingRepository<Article, Long>
    //extends CrudRepository<Article, Long>
{
}

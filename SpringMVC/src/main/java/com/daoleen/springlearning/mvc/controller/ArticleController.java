package com.daoleen.springlearning.mvc.controller;

import com.daoleen.springlearning.mvc.domain.Article;
import com.daoleen.springlearning.mvc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by alex on 1/3/14.
 */

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        List<Article> articles = articleService.findAll();
        uiModel.addAttribute("articles", articles);
        uiModel.addAttribute("name", "Matroskin");
        return "articles/list";
    }
}

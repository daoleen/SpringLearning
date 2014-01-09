package com.daoleen.springlearning.mvc.controller;

import com.daoleen.springlearning.mvc.domain.Article;
import com.daoleen.springlearning.mvc.service.ArticleService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by alex on 1/3/14.
 */

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // Для локализации сообщений об ошибках связывания
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        List<Article> articles = articleService.findAll();
        uiModel.addAttribute("articles", articles);
        uiModel.addAttribute("name", "Matroskin");
        return "articles/list";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        Article article = articleService.findById(id);
        uiModel.addAttribute("article", article);
        return "articles/show";
    }


    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") Long id, Model uiModel) {
        Article article = articleService.findById(id);
        uiModel.addAttribute("article", article);
        return "articles/form";
    }

    // @Valid включает проверку валидации (определенную с помощью Bean Validation API)!
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
    public String edit(@Valid Article article, BindingResult bindingResult, Model uiModel,
                       RedirectAttributes redirectAttributes, Locale locale)
            throws UnsupportedEncodingException {


        if(bindingResult.hasErrors()) {
            uiModel.addAttribute("system_notice",
                    messageSource.getMessage("error.binding", null, locale));
            uiModel.addAttribute("article", article);
            return "articles/form";
        }

        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("system_notice",
                messageSource.getMessage("notice.success_saved", null, locale));
        articleService.save(article);

                           // Здесь лучше обработать UnsupportedEncodingException, чем выносить вверх:)
        return "redirect:/articles/" + UriUtils.encodePathSegment(article.getId().toString(), "utf-8");
    }

    @RequestMapping(value = "/", params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        Article article = new Article();
        uiModel.addAttribute("article", article);
        return "articles/form";
    }

    // @Valid включает проверку валидации (определенную с помощью Bean Validation API)!
    @RequestMapping(value = "/", params="form", method=RequestMethod.POST)
    public String create(@Valid Article article, BindingResult bindingResult,
                         Locale locale, Model uiModel, RedirectAttributes redirectAttributes,
                         @RequestParam(value = "fileLogo", required=false) Part fileLogo)
            throws UnsupportedEncodingException {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("system_notice",
                    messageSource.getMessage("error.binding", null, locale));
            uiModel.addAttribute("article", article);
            return "articles/form";
        }

        // Загрузка файла
        // Внимание! Дальше идет мой код:)
        if(fileLogo != null) {
            // ковырять пути и файлы
            String path = "WEB-INF/web-resources/images/";
            String filename = article.getId() + ".png";
            Logger.getAnonymousLogger().warning("The image filename is: " + filename);
            try {
                fileLogo.write(path + filename);
                article.setLogo(filename);
            } catch (IOException e) {
                redirectAttributes.addFlashAttribute(
                        "system_notice", "Не удалось загрузить файл");
                Logger.getAnonymousLogger().warning("The IOException was thrown");
                e.printStackTrace();
            }
        }

        uiModel.asMap().clear();
        article = articleService.save(article);
        redirectAttributes.addFlashAttribute("system_notice",
                messageSource.getMessage("notice.success_saved", null, locale));
        return "redirect:/articles/" + UriUtils.encodePathSegment(article.getId().toString(), "utf-8");
    }


    // Представление разбиение записей на страницы
    // Также показано как можно получить произвольные параметры из URL'a
    @RequestMapping(value = "/pageable", method = RequestMethod.GET)
    public String listbypages(
            @RequestParam(value = "page", required = true, defaultValue = "1")Integer page,
            @RequestParam(value = "size", required = true, defaultValue = "3")Integer size,
            Model model) {

        // page - запрашиваемая страница
        // rows - количество записей на странице
        // также можно передавать orderBy, sortBy и пр. для сортировок
        Sort sort = new Sort(Sort.Direction.ASC, "name");   // указываем сортировку по возрастанию по полю name

        // Конструирование страничного запроса для текущей страницы.
        // ПРИМЕЧАНИЕ: нумерация страниц String Data JPA начинается с нуля!!!
        // Т.к. у меня с единицы, то -1:
        PageRequest pageRequest = new PageRequest(page-1, size, sort);

        Page<Article> articlesPage = articleService.findAllOnPage(pageRequest);
        model.addAttribute("articlesPage", articlesPage);

        Logger.getAnonymousLogger().info("total pages is: " + articlesPage.getTotalPages());
        Logger.getAnonymousLogger().info("current page is: " + articlesPage.getNumber());

        return "articles/articlesByPages";
    }
}

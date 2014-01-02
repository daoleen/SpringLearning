package com.daoleen.springlearning.hibernate.dao;

import com.daoleen.springlearning.hibernate.domain.Author;
import com.daoleen.springlearning.hibernate.repository.IAuthorRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 2:48 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository("authorDao")
@Transactional
public class AuthorDao implements IAuthorRepository {
    private Log log = LogFactory.getLog(getClass());
    private SessionFactory sessionFactory;
    private static Session session;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        session = sessionFactory.openSession();   // Need to be: sessionFactory.getCurrentSession()
    }

    @Override
    public List<Author> findAll() {
        return
                session
                     //.createQuery("from Author a").list();
                    .createQuery("from com.daoleen.springlearning.hibernate.domain.Author a").list();
    }

    @Override
    public Author findById(Long id) {
        return (Author) session
                .byId(Author.class)
                .getReference(id);
    }

    @Override
    public void save(Author author) {
        session.saveOrUpdate(author);
        log.info("Given object of Author has been saved with id: " + author.getId());
    }

    @Override
    public void delete(Author author) {
        session.delete(author);
        log.info("Deleted an author object with id: " + author.getId());
    }
}

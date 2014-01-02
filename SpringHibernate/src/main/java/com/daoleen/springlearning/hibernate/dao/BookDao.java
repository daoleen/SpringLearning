package com.daoleen.springlearning.hibernate.dao;

import com.daoleen.springlearning.hibernate.domain.Book;
import com.daoleen.springlearning.hibernate.repository.IBookRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 1:12 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository("bookDao")
@Transactional
public class BookDao implements IBookRepository {
    private Log log = LogFactory.getLog(getClass());
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return // Need to be: sessionFactory.getCurrentSession()  !!!
                sessionFactory.openSession()
                .createQuery("from Book b").list();
    }
}

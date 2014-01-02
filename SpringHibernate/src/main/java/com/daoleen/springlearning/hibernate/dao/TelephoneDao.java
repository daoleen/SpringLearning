package com.daoleen.springlearning.hibernate.dao;

import com.daoleen.springlearning.hibernate.domain.Telephone;
import com.daoleen.springlearning.hibernate.repository.ITelephoneRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 3:18 AM
 * To change this template use File | Settings | File Templates.
 */

@Transactional
@Repository("telephoneDao")
public class TelephoneDao implements ITelephoneRepository {
    private SessionFactory sessionFactory;

    @Override
    public List<Telephone> findAll() {
        return sessionFactory.openSession()
                .createQuery("from Telephone t").list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

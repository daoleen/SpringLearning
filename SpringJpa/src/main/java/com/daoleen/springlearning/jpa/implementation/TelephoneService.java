package com.daoleen.springlearning.jpa.implementation;

import com.daoleen.springlearning.jpa.domain.Telephone;
import com.daoleen.springlearning.jpa.repository.ITelephoneRepository;
import com.daoleen.springlearning.jpa.service.ITelephoneService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 1/1/14
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("telephoneService")
@Repository
@Transactional
public class TelephoneService implements ITelephoneService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired // Need to be enabled: <context:annotation-config />
    private ITelephoneRepository telephoneRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Telephone> findAll() {
        return Lists.newArrayList(telephoneRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Telephone> findByAuthorId(Long id) {
        return telephoneRepository.findByAuthorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Telephone> findByAuthorIdUsingJpql(Long id) {
        return entityManager.createQuery("select t from Telephone t where t.authorId = :id")
                .setParameter("id", id)
                .getResultList();
    }


    // Setters/Getters
    public ITelephoneRepository getTelephoneRepository() {
        return telephoneRepository;
    }

    public void setTelephoneRepository(ITelephoneRepository telephoneRepository) {
        this.telephoneRepository = telephoneRepository;
    }
}

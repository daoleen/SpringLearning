package com.daoleen.springlearning.jpa.repository;

import com.daoleen.springlearning.jpa.domain.Telephone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 11:58 PM
 * To change this template use File | Settings | File Templates.
 */

/// Another interesting interface is the JpaRepository<Entity, ID.class ext. Serializable>
/// public interface IAuthorRepository extends JpaRepository<Author, Long>
public interface ITelephoneRepository extends CrudRepository<Telephone, Long> {
    public List<Telephone> findByAuthorId(Long id);
}

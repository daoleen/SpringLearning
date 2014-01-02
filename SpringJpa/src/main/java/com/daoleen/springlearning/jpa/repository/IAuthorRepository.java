package com.daoleen.springlearning.jpa.repository;

import com.daoleen.springlearning.jpa.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 2:47 AM
 * To change this template use File | Settings | File Templates.
 */


/// Another interesting interface is the JpaRepository<Entity, ID.class ext. Serializable>
/// public interface IAuthorRepository extends JpaRepository<Author, Long>
public interface IAuthorRepository extends CrudRepository<Author, Long> {
    public Author findById(Long id);
}

package com.daoleen.springlearning.jpa.repository;

import com.daoleen.springlearning.jpa.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 1:11 AM
 * To change this template use File | Settings | File Templates.
 */

/// Another interesting interface is the JpaRepository<Entity, ID.class ext. Serializable>
/// public interface IAuthorRepository extends JpaRepository<Author, Long>
public interface IBookRepository extends CrudRepository<Book, Long> {
}

package com.daoleen.springlearning.transaction.repository;

import com.daoleen.springlearning.transaction.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alex on 1/2/14.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    @Query("select count(b) from Book b")
    public long countAllBooks();
}

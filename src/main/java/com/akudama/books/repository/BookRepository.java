package com.akudama.books.repository;

import com.akudama.books.domain.entity.Book;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();

    Optional<Book> findById(long id);

    @Override
    Book save(Book book);

    @Override
    void delete(Book book);

    void delete(long id);

    @Override
    long count();
}

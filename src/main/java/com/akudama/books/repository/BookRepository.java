package com.akudama.books.repository;

import com.akudama.books.domain.entity.Book;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();

    Optional<Book> findById(long id);

    Optional<List<Book>> findByAuthorsId(long id);

    @Override
    Book save(Book book);

    @Override
    void delete(Book book);

    void deleteById(long id);

    @Override
    long count();
}

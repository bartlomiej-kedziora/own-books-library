package com.akudama.books.repository;

import com.akudama.books.domain.entity.Author;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Override
    List<Author> findAll();

    Optional<Author> findById(long id);

    @Override
    Author save(Author author);

    @Override
    void delete(Author author);

    void deleteById(long id);

    @Override
    long count();
}

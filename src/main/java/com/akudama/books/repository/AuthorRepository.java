package com.akudama.books.repository;

import com.akudama.books.domain.entity.Author;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    @Override
    List<Author> findAll();

    Optional<Author> findById(long id);

    Optional<List<Author>> findByBooksId(long id);

    @Override
    Author save(Author author);

    @Override
    void delete(Author author);

    void deleteById(long id);

    @Override
    long count();
}

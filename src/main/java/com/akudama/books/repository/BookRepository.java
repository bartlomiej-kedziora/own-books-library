package com.akudama.books.repository;

import com.akudama.books.domain.entity.Book;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    Set<Book> findAll();

    Optional<Book> findById(long id);

    Optional<Set<Book>> findByAuthorsId(long id);

    Optional<Book> findByTitleAndTitleEngAndSeriesAndGenreAndYear(String title, String titleEng, String series,
            String genre, int year);

    @Override
    Book save(Book book);

    @Override
    void delete(Book book);

    void deleteById(long id);

    @Override
    long count();
}

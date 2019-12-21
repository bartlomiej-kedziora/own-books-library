package com.akudama.books.repository;

import com.akudama.books.domain.entity.Book;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();

    Optional<Book> findById(long id);

    Optional<List<Book>> findByAuthorsId(long id);

    Optional<Book> findByTitleAndTitleEngAndSeriesAndGenreAndYear(String title, String titleEng, String series,
            String genre, int year);

    @Override
    Book save(Book book);

    @Override
    void delete(Book book);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
